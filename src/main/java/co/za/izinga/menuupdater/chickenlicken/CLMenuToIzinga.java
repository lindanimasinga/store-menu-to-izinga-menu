package co.za.izinga.menuupdater.chickenlicken;

import co.za.izinga.menuupdater.chickenlicken.categories.Categories;
import co.za.izinga.menuupdater.chickenlicken.categories.Datum;
import co.za.izinga.menuupdater.chickenlicken.product.Product;
import co.za.izinga.menuupdater.model.BusinessHours;
import co.za.izinga.menuupdater.model.Stock;
import co.za.izinga.menuupdater.model.StoreProfile;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.za.izinga.menuupdater.Application.*;
import static co.za.izinga.menuupdater.chickenlicken.categories.DataType.IMAGE_SETS;
import static co.za.izinga.menuupdater.chickenlicken.categories.DataType.MEDIA;

public class CLMenuToIzinga {

    static String CHICKEN_L_URL = "https://chickenlicken.co.za/api/v1";

    public static StoreProfile loadChickenLMenu(StoreProfile clStoreProfile) throws IOException {
        String categoriesUrl = CHICKEN_L_URL + "/categories?filter[global-sort]=true&include=image-set.categoryImage,image-set.categoryImageLarge,image-set.categoryImageMobi,image-set.categoryImageProduct,image-set.categoryImageProductHover,image-set.categoryImageProductBackground,products,products.side-item.image-set.sideItemImage,products.related,products.related.image-set.productImage,products.related.image-set.topNavigationImage,products.related.image-set.productImageLarge,products.image-set.productImage,products.image-set.topNavigationImage,products.image-set.productImageLarge";
        Request request = new Request.Builder().url(categoriesUrl).build();
        Response response = Objects.requireNonNull(client.newCall(request)).execute();
        byte[] responseBodyBytes = Objects.requireNonNull(response.body()).bytes();
        Categories chickenLCategories = mapper.readValue(responseBodyBytes, Categories.class);
        response.close();

        Set<Stock> stock = new HashSet<>();
        clStoreProfile.setStockList(stock);
        Product products = null;
        for (Datum category : chickenLCategories.getData()) {
            String productsUrl = category.getRelationships().getProducts().getLinks().getRelated();
            Request prodRequest = new Request.Builder().url(productsUrl).build();
            byte[] productsResponseBodyBytes = Objects.requireNonNull(client.newCall(prodRequest).execute().body()).bytes();
            products = mapper.readValue(productsResponseBodyBytes, Product.class);

            for (co.za.izinga.menuupdater.chickenlicken.product.Datum product : products.getData()) {
                Stock stockItem = new Stock();
                stockItem.setName(product.getAttributes().getTitle());

                stockItem.setName(cleanName(product.getAttributes().getTitle()));

                stockItem.setDescription(cleanName(product.getAttributes().getTitle()));;

                stockItem.setStorePrice(product.getAttributes().getPrice() / 100.00);

                String imageSetId = product.getRelationships().getImageSet().getData().getId();
                String imageId = Arrays.stream(chickenLCategories.getIncluded())
                        .filter(it -> it.getID().equals(imageSetId) && it.getType() == IMAGE_SETS)
                        .findFirst().get()
                        .getRelationships()
                        .getProductImage()
                        .getData()
                        .getID();
                String imageUrl = Arrays.stream(chickenLCategories.getIncluded())
                        .filter(it -> it.getID().equals(imageId) && it.getType() == MEDIA)
                        .findFirst().get()
                        .getAttributes()
                        .getURL();

                stockItem.setImages(List.of("https://chickenlicken.co.za" + imageUrl));
                stockItem.setGroup(cleanName((category.getAttributes().getTitle() + " " + category.getAttributes().getSubtitle())));
                stockItem.setQuantity(100);
                stockItem.setMandatorySelection(Collections.emptyList());
                boolean shouldIgnoreGroup = Objects.equals("LICK N LEKKER", stockItem.getGroup());
                if (!shouldIgnoreGroup) {
                    stock.add(stockItem);
                }
            }
        }

        List<String> tags = List.of("restaurant", "Chicken", "Drinks", "Burger");
        clStoreProfile.setTags(tags);
        clStoreProfile.setFranchiseName("chickenlicken");
        List<BusinessHours> hours = Stream.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY).map(dayOfWeek ->
                new BusinessHours(dayOfWeek,
                        Date.from(LocalDate.now().atTime(9,0,0).toInstant(ZoneOffset.ofHours(0))),
                        Date.from(LocalDate.now().atTime(18,0,0).toInstant(ZoneOffset.ofHours(0)))
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
                .trim();
    }
}
