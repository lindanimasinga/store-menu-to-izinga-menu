package co.za.izinga.menuupdater.nandos;

import co.za.izinga.menuupdater.model.BusinessHours;
import co.za.izinga.menuupdater.model.SelectionOption;
import co.za.izinga.menuupdater.model.Stock;
import co.za.izinga.menuupdater.model.StoreProfile;
import co.za.izinga.menuupdater.nandos.model.NandosMenu;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.za.izinga.menuupdater.Application.client;
import static co.za.izinga.menuupdater.Application.mapper;
import static co.za.izinga.menuupdater.chickenlicken.CLMenuToIzinga.cleanName;

public class NandosToIzinga {

    static String NANDOS_URL = "https://api.nandos.co.za/api/v2/pack/menu/default";

    public static StoreProfile loadNandosLMenu(StoreProfile nandosStore) throws IOException {
        Request request = new Request.Builder().url(NANDOS_URL).build();
        Response response = Objects.requireNonNull(client.newCall(request)).execute();
        byte[] responseBodyBytes = Objects.requireNonNull(response.body()).bytes();
        NandosMenu nandosMenu = mapper.readValue(responseBodyBytes, NandosMenu.class);
        response.close();

        Set<Stock> stock = new HashSet<>();
        for (NandosMenu.Product product : nandosMenu.data.menu.products) {

            Stock stockItem = new Stock();
            NandosMenu.ProductDefinition productDefinition = nandosMenu.data.menu.productDefinitions.stream()
                .filter(it -> it.id.equals(product.productDefinitionId)).findFirst().orElseThrow();

            stockItem.setName(cleanName(productDefinition.name));
            stockItem.setDescription(cleanName(productDefinition.description));;
            stockItem.setStorePrice(product.price / 100.00);

            List<String> images = productDefinition.images == null? Collections.emptyList() :
                    productDefinition.images.stream().map(im -> im.path).collect(Collectors.toList());
            stockItem.setImages(images);
            nandosMenu.data.menu.categories.stream()
                    .filter(it -> it.children.stream().anyMatch(id -> id.destinationId.equals(productDefinition.id)))
                    .findFirst()
                    .ifPresent(category -> stockItem.setGroup(cleanName(category.name)));
            stockItem.setQuantity(100);

            List<SelectionOption> mandatorySelection = product.relatedProducts == null ? Collections.emptyList() : product.relatedProducts.stream()
                    .flatMap(relatedProduct -> getSelectionOptions(nandosMenu, relatedProduct).stream())
                    .collect(Collectors.toList());

            stockItem.setMandatorySelection(mandatorySelection);
            boolean shouldIgnoreGroup = Objects.equals("LICK N LEKKER", stockItem.getGroup());
            if (!shouldIgnoreGroup) {
                stock.add(stockItem);
            }
        }

        nandosStore.setStockList(stock);
        List<String> tags = List.of("restaurant", "Chicken", "Drinks", "Burger");
        nandosStore.setTags(tags);
        nandosStore.setFeatured(true);
        nandosStore.setFeaturedExpiry(Date.from(LocalDateTime.now().plusMonths(3).toInstant(ZoneOffset.ofHours(0))));
        nandosStore.setFranchiseName("nandos");
        List<BusinessHours> hours = Stream.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY).map(dayOfWeek ->
                new BusinessHours(dayOfWeek,
                        Date.from(LocalDate.now().atTime(9,0,0).toInstant(ZoneOffset.ofHours(0))),
                        Date.from(LocalDate.now().atTime(18,0,0).toInstant(ZoneOffset.ofHours(0)))
                )
        ).collect(Collectors.toList());
        nandosStore.setBusinessHours(hours);
        return nandosStore;
    }

    private static List<SelectionOption> getSelectionOptions(NandosMenu nandosMenu, NandosMenu.RelatedProduct relatedProduct) {
        if(relatedProduct.relatedProducts == null) return List.of();

        if (relatedProduct.relatedProducts.stream().allMatch(it -> it.relatedProducts == null || it.relatedProducts.isEmpty())) {
            SelectionOption option = createASelectionOption(nandosMenu, relatedProduct);
            return option == null ? List.of() : List.of(option);
        }

        return relatedProduct.relatedProducts.stream()
                .flatMap( rt -> rt.relatedProducts != null ? rt.relatedProducts.stream() : Stream.of(rt))
                .flatMap(it -> getSelectionOptions(nandosMenu, it).stream())
                .collect(Collectors.toList());
    }

    private static SelectionOption createASelectionOption(NandosMenu nandosMenu, NandosMenu.RelatedProduct relatedProduct) {
        NandosMenu.ProductDefinition relatedProductDefinition = nandosMenu.data.menu.productDefinitions.stream()
                .filter(it -> it.id.equals(relatedProduct.productDefinitionId)).findFirst().orElseThrow();
        String optionName = relatedProductDefinition.name;

        List<String> selection = nandosMenu.data.menu.productDefinitions.stream()
                .filter(it -> relatedProduct.relatedProducts.stream()
                        .anyMatch(item -> item.productDefinitionId.equals(it.id))
                )
                .map(it -> it.name)
                .collect(Collectors.toList());

        if (shouldExclude(optionName)) return null;
        SelectionOption option = new SelectionOption();
        option.setName(optionName);
        option.setSelected("None");
        selection.add("None");
        option.setValues(selection);
        return option;
    }

    private static boolean shouldExclude(String optionName) {
        return exclusions.contains(optionName.toLowerCase());
    }

    private static final List<String> exclusions = List.of("add a drink & save");
}
