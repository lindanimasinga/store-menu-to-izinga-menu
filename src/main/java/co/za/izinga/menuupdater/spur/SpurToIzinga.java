package co.za.izinga.menuupdater.spur;

import co.za.izinga.menuupdater.mcdonals.McDonaldsToIzinga;
import co.za.izinga.menuupdater.mcdonals.model.Root;
import co.za.izinga.menuupdater.model.Stock;
import co.za.izinga.menuupdater.model.StoreProfile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.za.izinga.menuupdater.Application.mapper;
import static co.za.izinga.menuupdater.chickenlicken.CLMenuToIzinga.cleanName;

public class SpurToIzinga {

    public static StoreProfile loadSpurMenu(StoreProfile spurStore) throws IOException, URISyntaxException {
        var fileuri = McDonaldsToIzinga.class.getClassLoader().getResource("spurMenu.json").toURI();
        var mcdMenu = mapper.readValue(new File(fileuri), Root.class);
        var stock1 = mcdMenu.data.catalogSectionsMap.selectionMap3.stream()
                .map(sec -> sec.payload)
                .flatMap(load -> {
                    var category = load.standardItemsPayload.title.text;
                    return load.standardItemsPayload.catalogItems.stream()
                            .filter(i -> i.isAvailable)
                            .map(item -> {
                                var stock = new Stock();
                                stock.setName(cleanName(item.title));
                                stock.setGroup(cleanName(category));
                                stock.setDescription(cleanName(item.itemDescription));
                                stock.setStorePrice(item.price/100.00);
                                stock.setQuantity(1000);
                                stock.setImages(List.of(item.imageUrl));
                                stock.setMandatorySelection(List.of());
                                return stock;
                            });
                }).collect(Collectors.toSet());
        spurStore.setStockList(stock1);
        spurStore.setMarkUpPrice(false);
        return spurStore;
    }
}
