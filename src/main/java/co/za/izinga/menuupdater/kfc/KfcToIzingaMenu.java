package co.za.izinga.menuupdater.kfc;

import co.za.izinga.menuupdater.kfc.model.*;
import co.za.izinga.menuupdater.model.BusinessHours;
import co.za.izinga.menuupdater.model.Stock;
import co.za.izinga.menuupdater.model.StoreProfile;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.*;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.za.izinga.menuupdater.Application.client;
import static co.za.izinga.menuupdater.Application.mapper;
import static co.za.izinga.menuupdater.chickenlicken.CLMenuToIzinga.cleanName;

public class KfcToIzingaMenu {

    private static final String KFC_URL = "https://orderserv-kfc-eu-olo-api.yum.com/dev/v1";

    private static Set<Stock> stock = new HashSet<>();

    public static StoreProfile loadKfcMenu(StoreProfile kfcStore) throws IOException {
        if(stock.isEmpty()) {
            var kfcData = fetKfcData("/catalogs/5f89a603781e4df48d31337a6c1252a8/KFCSouthAfricaMenu-KSA064-web-pickup", KfcResponse.class);
            var excludedProducts = fetKfcData("/stores/KSA743/web/pickup/item-exclusions", new TypeReference<List<Exclusion>>() {});
            List<String> excludedCategories = List.of("Delivery Deals");

            for (Category category : kfcData.getCategories().get(0).getCategories()) {
                if(excludedCategories.contains(cleanName(category.getName()))) continue;
                Arrays.stream(category.getProducts()).forEach(items -> {
                    var availability = Arrays.stream(items.getItems())
                            .flatMap(i -> Stream.of(i.getAvailability())).findFirst();
                    var price = availability.map(a -> a.getPrice()/100.00).orElse(0.00);
                    var availableEveryDay = availability.map(a -> Day.EVERYDAY == a.getDayOfWeek().getDay()).orElse(false);
                    var isAvailableAtThisTime = availability.map(KfcToIzingaMenu::isAvailableNow).orElse(false);
                    if (price > 0 && availableEveryDay && isAvailableAtThisTime && !isProductExcluded(items, excludedProducts, kfcStore.getExternalId())) {
                        Stock stockItem = new Stock();
                        stockItem.setName(items.getName());
                        stockItem.setDescription(items.getShortDescription()[0].getValue());
                        stockItem.setStorePrice(price);

                        stockItem.setImages(List.of(items.getImageName()));
                        stockItem.setGroup(cleanName(category.getName()));
                        stockItem.setQuantity(100);
                        stockItem.setExternalUrlPath(category.getName() + "/" + items.getName());
                        stockItem.setMandatorySelection(List.of());
                        boolean shouldIgnoreGroup = false;
                        if (!shouldIgnoreGroup) {
                            stock.add(stockItem);
                        }
                    }
                });
            }
        }
        kfcStore.setStockList(stock);
        List<String> tags = List.of("restaurant", "Chicken", "Drinks", "Burger");
        kfcStore.setTags(tags);
        kfcStore.setFeatured(true);
        kfcStore.setFeaturedExpiry(Date.from(LocalDateTime.now().plusMonths(3).toInstant(ZoneOffset.ofHours(0))));
        kfcStore.setFranchiseName("KFC");
        kfcStore.setStoreWebsiteUrl(KFC_URL);
        List<BusinessHours> hours = Stream.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY).map(dayOfWeek ->
                new BusinessHours(dayOfWeek,
                        Date.from(LocalDate.now().atTime(9,0,0).toInstant(ZoneOffset.ofHours(0))),
                        Date.from(LocalDate.now().atTime(18,0,0).toInstant(ZoneOffset.ofHours(0)))
                )
        ).collect(Collectors.toList());
        kfcStore.setBusinessHours(hours);
        return kfcStore;
    }

    private static boolean isAvailableNow(Availability availability) {
        var availableFrom = LocalTime.parse(availability.getAvailableHours().getStartTime().getTime());
        var availableTo = LocalTime.parse(availability.getAvailableHours().getEndTime().getTime());
        var now = LocalTime.now().plusHours(2); //SA time
        return now.isAfter(availableFrom) && now.isBefore(availableTo);
    }

    private static boolean isProductExcluded(Product items, List<Exclusion> excludedProducts, String storeId) {
        return excludedProducts.stream()
                .anyMatch(ex -> ex.getStoreId().equals(storeId) && ex.getItemId().equals(items.getId()));
    }

    private static <T> T fetKfcData(String path, Class<T> clazz) throws IOException {
        Request request = new Request.Builder()
                .url(KFC_URL + path)
                .header("x-tenant-id", "5f89a603781e4df48d31337a6c1252a8")
                .build();
        Response response = Objects.requireNonNull(client.newCall(request)).execute();
        var responseBodyString = Objects.requireNonNull(response.body()).string();
        response.close();
        return mapper.readValue(responseBodyString, clazz);
    }

    private static <T> List<T> fetKfcData(String path, TypeReference<List<T>> clazz) throws IOException {
        Request request = new Request.Builder()
                .url(KFC_URL + path)
                .header("x-tenant-id", "5f89a603781e4df48d31337a6c1252a8")
                .build();
        Response response = Objects.requireNonNull(client.newCall(request)).execute();
        var responseBodyString = Objects.requireNonNull(response.body()).string();
        response.close();
        return mapper.readValue(responseBodyString, clazz);
    }
}
