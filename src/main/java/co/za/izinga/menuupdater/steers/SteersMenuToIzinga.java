package co.za.izinga.menuupdater.steers;

import co.za.izinga.menuupdater.model.*;
import co.za.izinga.menuupdater.steers.model.MenuItem;
import co.za.izinga.menuupdater.steers.model.Option;
import co.za.izinga.menuupdater.steers.model.ShopLocation;
import co.za.izinga.menuupdater.steers.model.SteersMenu;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.Request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.za.izinga.menuupdater.Application.*;

public class SteersMenuToIzinga {

    public static StoreProfile convertToIzingaStore(String name, String shortName, String address,
                                                    String contacts, String description, String imageUrl,
                                                    double latitude, double longitude, List<String> tags, SteersMenu steersMenu) {
        @NotEmpty List<BusinessHours> businessHours = List.of(new BusinessHours(DayOfWeek.FRIDAY, new Date(), new Date()));
        @NotNull(message = "Shop bank not valid") Bank bank = new Bank();
        StoreProfile profile = new StoreProfile(
                StoreType.FOOD,
                name,
                shortName,
                address,
                "image url",
                contacts,
                List.of("Burger", "Chips", "Restaurant"),
                businessHours,
                "6c45f9e0-dd55-4059-870c-08d578a259e6",
                bank
        );
        profile.setImageUrl(imageUrl);
        profile.setDescription(description);
        profile.setLatitude(latitude);
        profile.setLongitude(longitude);
        profile.setTags(tags);
        profile.setFeatured(true);
        profile.setFeaturedExpiry(new Date());

        Set<Stock> stockList = new HashSet<>();
        //convert steer menu to izinga menu
        steersMenu.getCategories().stream()
                .filter(ct -> !"treats".equalsIgnoreCase(ct.getName()))
                .forEach(category -> {
                    category.getMenuItems().stream().filter(i -> !i.isIsUnavailable()).forEach(menuItem -> {
                        Stock item = new Stock();
                        if (menuItem.getName() != null) {
                            item.setName(menuItem.getName().replace("®", "")
                                    .replace("ñ", "n")
                                    .replace("‘", ""));
                        }
                        if (menuItem.getDescription() != null) {
                            item.setDescription(menuItem.getDescription().replace("®", "")
                                    .replace("ñ", "n")
                                    .replace("‘", ""));
                        }
                        item.setStorePrice(menuItem.getPrice());
                        item.setImages(List.of("https:" + menuItem.getImageUrl()));
                        item.setGroup(category.getName());

                        menuItem.getOptionLists().forEach(m -> {
                            List<SelectionOption> selection = new ArrayList<>();
                            SelectionOption option = new SelectionOption();
                            option.setName(m.getName());
                            option.setSelected("None");
                            selection.add(option);
                            List<String> values = m.getOptions()
                                    .stream()
                                    .filter(option1 -> option1.getPrice() == 0 && option1.getOptionLists().isEmpty())
                                    .map(Option::getName)
                                    .collect(Collectors.toList());
                            option.setValues(values);
                            if(!option.getValues().isEmpty()) {
                                item.setMandatorySelection(selection);
                            }
                        });
                        item.setQuantity(100);
                        stockList.add(item);
                    });
                });
        profile.setStockList(stockList);
        return profile;
    }

    private static StoreProfile getStoreProfile(StoreProfile store, String storeUrl, List<String> restaurantTags, String franchiseName) throws IOException {

        if(store.getExternalId() == null || store.getExternalId().isEmpty()) {
            getShopLocationInformation(storeUrl, new GeoPointImpl(store.getLatitude(), store.getLongitude())).ifPresent(it ->
            store.setExternalId(it.getId() + ""));
        }

        //this store has been closed and longer available
        if(store.getExternalId() == null || store.getExternalId().isEmpty()) {
            store.setAvailability(StoreProfile.AVAILABILITY.OFFLINE);
            return store;
        }

        String fullUrl = String.format("%s/menu/listing?storeId=%s&orderType=Delivery", storeUrl, store.getExternalId());
        Request request = new Request.Builder().url(fullUrl).build();
        byte[] responseBodyBytes = Objects.requireNonNull(client.newCall(request).execute().body()).bytes();
        SteersMenu steersMenu = mapper.readValue(responseBodyBytes, SteersMenu.class);
        steersMenu.getCategories()
                .stream()
                .flatMap(category -> category.getMenuItems().stream())
                .forEach(item -> {
                    String url = String.format("%s/menuitem?menuItemId=%d&storeId=%s&orderType=Delivery", storeUrl, item.getId(), store.getExternalId());
                    Request request2 = new Request.Builder().url(url).build();
                    try {
                        byte[] responseBodyBytes2 = Objects.requireNonNull(client.newCall(request2).execute().body()).bytes();
                        MenuItem detailedMenuItem = mapper.readValue(responseBodyBytes2, MenuItem.class);
                        item.setOptionLists(detailedMenuItem.getOptionLists());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        //update menu
        List<String> tags = restaurantTags;
        store.setTags(tags);
        updateIzingaStore(store, steersMenu);
        store.setFranchiseName(franchiseName);
        return store;
    }

    public static StoreProfile loadSteersMidWay(StoreProfile steersStore) throws IOException {
        return getStoreProfile(steersStore, STEERS_URL, List.of("restaurant", "Burger", "Chips"), "Steers");
    }

    public static StoreProfile loadDeboniarsMidway(StoreProfile debonairsStore) throws IOException {
        return getStoreProfile(debonairsStore, DEBON_URL, List.of("restaurant", "Pizza", "Drinks"), "Debonairs");
    }

    public static StoreProfile loadPedrosMidway(StoreProfile pedrosStore) throws IOException {
        return getStoreProfile(pedrosStore, PEDROS_URL, List.of("restaurant", "Chicken", "Drinks"), "Pedros");
    }

    public static StoreProfile loadWimpy(StoreProfile wimpyStore) throws IOException {
        return getStoreProfile(wimpyStore, WIMPY_URL, List.of("restaurant", "Chicken", "Drinks"), "Wimpy");
    }

    public static StoreProfile loadFishaways(StoreProfile fishawaysStore) throws IOException {
        return getStoreProfile(fishawaysStore, FISHAWAYS, List.of("restaurant", "Fish", "Hake", "Calamari", "Prawns", "Drinks"), "Fishaways");
    }

    public static void updateIzingaStore(StoreProfile profile, SteersMenu steersMenu) {
        Set<Stock> stockList = new HashSet<>();
        //convert steer menu to izinga menu
        steersMenu.getCategories().stream()
                .filter(ct -> !"treats".equalsIgnoreCase(ct.getName()))
                .forEach(category -> {
                    category.getMenuItems().stream().filter(i -> !i.isIsUnavailable()). forEach(menuItem -> {
                        Stock item = new Stock();
                        if (menuItem.getName() != null) {
                            item.setName(menuItem.getName().replace("®", "")
                                    .replace("ñ", "n")
                                    .replace("™", "")
                                    .replace("è", "e")
                                    .replace("Ã", "")
                                    .replace("¢", "")
                                    .replace("\u0080", "")
                                    .replace("‘", ""));
                        }
                        if (menuItem.getDescription() != null) {
                            item.setDescription(menuItem.getDescription().replace("®", "")
                                    .replace("ñ", "n")
                                    .replace("™", "")
                                    .replace("è", "e")
                                    .replace("Ã", "")
                                    .replace("¢", "")
                                    .replace("\u0080", "")
                                    .replace("‘", ""));
                        }
                        item.setStorePrice(menuItem.getPrice());
                        item.setImages(List.of("https:" + menuItem.getImageUrl()));
                        item.setGroup(category.getName());

                        menuItem.getOptionLists().forEach(m -> {
                            List<SelectionOption> selection = new ArrayList<>();
                            SelectionOption option = new SelectionOption();
                            option.setName(m.getName());
                            option.setSelected("None");
                            selection.add(option);
                            List<String> values = m.getOptions()
                                    .stream()
                                    .filter(option1 -> option1.getPrice() == 0 && option1.getOptionLists().isEmpty())
                                    .map(Option::getName)
                                    .collect(Collectors.toList());
                            option.setValues(values);
                            item.setMandatorySelection(!option.getValues().isEmpty() ? selection : Collections.emptyList());
                        });

                        if(item.getMandatorySelection() == null) {
                            item.setMandatorySelection(Collections.emptyList());
                        }
                        item.setQuantity(100);
                        stockList.add(item);
                    });
                });
        profile.setStockList(stockList);
        List<BusinessHours> hours = Stream.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY).map(dayOfWeek ->
                new BusinessHours(dayOfWeek,
                        Date.from(LocalDate.now().atTime(9,0,0).toInstant(ZoneOffset.ofHours(0))),
                        Date.from(LocalDate.now().atTime(18,0,0).toInstant(ZoneOffset.ofHours(0)))
                )
        ).collect(Collectors.toList());
        profile.setBusinessHours(hours);
    }

    public static Optional<ShopLocation> getShopLocationInformation(String franshiseUrl, GeoPoint geoPoint) throws IOException {
        String SteersUrl = String.format("%s/stores/nearby?longitude=%s&latitude=%s&radiusInMeters=200&requestedDate", franshiseUrl, geoPoint.getLongitude(), geoPoint.getLatitude());
        Request request = new Request.Builder().url(SteersUrl).build();
        byte[] responseBodyBytes = Objects.requireNonNull(client.newCall(request).execute().body()).bytes();
        return mapper.readValue(responseBodyBytes, new TypeReference<List<ShopLocation>>() {}).stream().findFirst();
    }
}
