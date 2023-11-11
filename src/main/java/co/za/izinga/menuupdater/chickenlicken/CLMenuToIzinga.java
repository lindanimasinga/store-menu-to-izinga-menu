package co.za.izinga.menuupdater.chickenlicken;

import co.za.izinga.menuupdater.chickenlicken.categories.CategoryDetails;
import co.za.izinga.menuupdater.chickenlicken.categories.CategorySummary;
import co.za.izinga.menuupdater.model.BusinessHours;
import co.za.izinga.menuupdater.model.Stock;
import co.za.izinga.menuupdater.model.StoreProfile;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.za.izinga.menuupdater.Application.client;
import static co.za.izinga.menuupdater.Application.mapper;

public class CLMenuToIzinga {

    static String CHICKEN_L_URL = "https://chickenlicken.co.za";

    public static StoreProfile loadChickenLMenu(StoreProfile clStoreProfile) throws IOException {
        String categoriesUrl = CHICKEN_L_URL + "/json/menu.php";
        Request request = new Request.Builder().url(categoriesUrl).build();
        Response response = Objects.requireNonNull(client.newCall(request)).execute();
        byte[] responseBodyBytes = Objects.requireNonNull(response.body()).bytes();
        List<CategorySummary> chickenLCategorySummary = mapper.readValue(responseBodyBytes, new TypeReference<>() {});
        response.close();

        Set<Stock> stock = new HashSet<>();
        clStoreProfile.setStockList(stock);

        for (CategorySummary summary : chickenLCategorySummary) {
            String categoryDetailsUrl = String.format("%s/json/menu_category.php?categoryid=%s", CHICKEN_L_URL, summary.getId());
            Request request2 = new Request.Builder().url(categoryDetailsUrl).build();
            Response response2 = Objects.requireNonNull(client.newCall(request2)).execute();
            byte[] responseBodyBytes2 = Objects.requireNonNull(response2.body()).bytes();
            CategoryDetails categoryDetails = mapper.readValue(responseBodyBytes2, CategoryDetails.class);
            response2.close();

            categoryDetails.getProducts().forEach(product -> {
                Stock stockItem = new Stock();
                stockItem.setName(cleanName(product.getTitle()));
                stockItem.setDescription(cleanName(product.getTitle()));
                stockItem.setStorePrice(product.getPrice() / 100.00);
                String imageUrl = product.getImageSet().getProductImage().getUrl();
                stockItem.setImages(List.of("https://chickenlicken.co.za" + imageUrl));
                stockItem.setGroup(cleanName((summary.getTitle() + " " + summary.getSubtitle())));
                stockItem.setQuantity(100);
                stockItem.setMandatorySelection(Collections.emptyList());
                boolean shouldIgnoreGroup = Objects.equals("LICK N LEKKER", stockItem.getGroup());
                if (!shouldIgnoreGroup) {
                    stock.add(stockItem);
                }
            });
        }

        List<String> tags = List.of("restaurant", "Chicken", "Drinks", "Burger");
        clStoreProfile.setTags(tags);
        clStoreProfile.setFranchiseName("chickenlicken");
        List<BusinessHours> hours = Stream.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY).map(dayOfWeek ->
                new BusinessHours(dayOfWeek,
                        Date.from(LocalDate.now().atTime(9, 0, 0).toInstant(ZoneOffset.ofHours(0))),
                        Date.from(LocalDate.now().atTime(18, 0, 0).toInstant(ZoneOffset.ofHours(0)))
                )
        ).collect(Collectors.toList());
        clStoreProfile.setBusinessHours(hours);
        return clStoreProfile;
    }

    public static String cleanName(String code) {
        return code == null ? "" : code.replace("circle-", "")
                .replace("-ce", "")
                .replace("-g-Mix-eg-", "")
                .replace("-g-Mix-eg", "")
                .replace("-ef22-", "")
                .replace("-f22-", "")
                .replace("-n-2-en-", "")
                .replace("-sl-x-esl-", "")
                .replace("ñ", "n")
                .replace("‘", "")
                .replace("™", "")
                .replace("’n", " n")
                .replace("’N", " N")
                .replace("S’", "S'")
                .replace("®", "")
                .replace("&#153;", "")
                .replace("&#146;", "")
                .trim();
    }
}
