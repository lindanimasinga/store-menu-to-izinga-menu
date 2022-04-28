package co.za.izinga.menuupdater.steers;

import co.za.izinga.menuupdater.model.*;
import co.za.izinga.menuupdater.steers.model.MenuItem;
import co.za.izinga.menuupdater.steers.model.Option;
import co.za.izinga.menuupdater.steers.model.SteersMenu;
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

    public static void updateIzingaStore(StoreProfile profile, SteersMenu steersMenu) {
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
                                    Date.from(LocalDate.now().atTime(9,0,0).toInstant(ZoneOffset.ofHours(2))),
                                    Date.from(LocalDate.now().atTime(18,0,0).toInstant(ZoneOffset.ofHours(2)))
                            )
                        ).collect(Collectors.toList());
        profile.setBusinessHours(hours);
    }

    public static StoreProfile loadSteersMidWay(StoreProfile steersStore) throws IOException {
        String SteersUrl = STEERS_URL + "/menu/listing?storeId=8143&orderType=Delivery";
        Request request = new Request.Builder().url(SteersUrl).build();
        byte[] responseBodyBytes = Objects.requireNonNull(client.newCall(request).execute().body()).bytes();
        SteersMenu steersMenu = mapper.readValue(responseBodyBytes, SteersMenu.class);
        steersMenu.getCategories()
                .stream()
                .flatMap(category -> category.getMenuItems().stream())
                .forEach(item -> {
                    String url = STEERS_URL + "/menuitem?menuItemId="+item.getId()+"&storeId=8143&orderType=Delivery";
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
        List<String> tags = List.of("restaurant", "Burger", "Chips");
        steersStore.setTags(tags);
        SteersMenuToIzinga.updateIzingaStore(steersStore, steersMenu);
        steersStore.setFranchiseName("Steers");
        return steersStore;
    }

    public static StoreProfile loadDeboniarsMidway(StoreProfile debonairsStore) throws IOException {
        String SteersUrl = DEBON_URL + "/menu/listing?storeId=5360&orderType=Delivery";
        Request request = new Request.Builder().url(SteersUrl).build();
        byte[] responseBodyBytes = Objects.requireNonNull(client.newCall(request).execute().body()).bytes();
        SteersMenu debonairsMenu = mapper.readValue(responseBodyBytes, SteersMenu.class);

        debonairsMenu.getCategories()
                .stream()
                .flatMap(category -> category.getMenuItems().stream())
                .forEach(item -> {
                    String url = STEERS_URL + "/menuitem?menuItemId="+item.getId()+"&storeId=5360&orderType=Delivery";
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
        List<String> tags = List.of("restaurant", "Pizza", "Drinks");
        debonairsStore.setTags(tags);
        SteersMenuToIzinga.updateIzingaStore(debonairsStore ,debonairsMenu);
        debonairsStore.setFranchiseName("Debonairs");
        return debonairsStore;
    }

    public static StoreProfile loadPedrosMidway(StoreProfile pedrosStore) throws IOException {
        String SteersUrl = PEDROS_URL + "/menu/listing?storeId=8150&orderType=Delivery";
        Request request = new Request.Builder().url(SteersUrl).build();
        byte[] responseBodyBytes = Objects.requireNonNull(client.newCall(request).execute().body()).bytes();
        SteersMenu pedrosMenu = mapper.readValue(responseBodyBytes, SteersMenu.class);

        pedrosMenu.getCategories()
                .stream()
                .flatMap(category -> category.getMenuItems().stream())
                .forEach(item -> {
                    String url = PEDROS_URL + "/menuitem?menuItemId="+item.getId()+"&storeId=8150&orderType=Delivery";
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
        List<String> tags = List.of("restaurant", "Chicken", "Drinks");
        pedrosStore.setTags(tags);
        SteersMenuToIzinga.updateIzingaStore(pedrosStore ,pedrosMenu);
        pedrosStore.setFranchiseName("Pedros");
        return pedrosStore;
    }
}
