package co.za.izinga.menuupdater.mcdonals;

import co.za.izinga.menuupdater.mcdonals.model.Root;
import co.za.izinga.menuupdater.model.Stock;
import co.za.izinga.menuupdater.model.StoreProfile;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.za.izinga.menuupdater.Application.client;
import static co.za.izinga.menuupdater.Application.mapper;
import static co.za.izinga.menuupdater.chickenlicken.CLMenuToIzinga.cleanName;

public class McDonaldsToIzinga {

    public static StoreProfile loadMcdonalsMenu(StoreProfile kfcStore) throws IOException, URISyntaxException {
        //var fileuri = McDonaldsToIzinga.class.getClassLoader().getResource("mcdonalsMenu.json").toURI();
        //var mcdMenu = mapper.readValue(new File(fileuri), Root.class);
        var mcdMenu = fetchMcdData(Root.class, "c2317729-65c4-4fd4-8f18-c3f3e6636366");
        var stock1 = Stream.concat(mcdMenu.data.catalogSectionsMap.mcdCatalog.stream(), mcdMenu.data.catalogSectionsMap.selectionMap2.stream())
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
                                stock.setStorePrice(item.price/100.00 * 0.8); //this is uber price make less to 80%
                                stock.setQuantity(1000);
                                if (item.imageUrl != null) {
                                    stock.setImages(List.of(item.imageUrl));
                                }
                                stock.setMandatorySelection(List.of());
                                return stock;
                            });
                }).collect(Collectors.toSet());
        kfcStore.setStockList(stock1);
        kfcStore.setMarkUpPrice(false);
        return kfcStore;
    }

    public static <T> T fetchMcdData(Class<T> clazz, String uuid) throws IOException {
        Request request = new Request.Builder()
                .url("https://www.ubereats.com/_p/api/getStoreV1?localeCode=za")
                .header("x-csrf-token", "x")
                //.header("cookie", cookie)
                .post(RequestBody.create(MediaType.parse("application/json"),
                        String.format("{\"storeUuid\":\"%s\",\"diningMode\":\"DELIVERY\",\"time\":{\"asap\":true},\"cbType\":\"EATER_ENDORSED\"}", uuid)))
                .build();
        Response response = Objects.requireNonNull(client.newCall(request)).execute();
        var responseBodyString = Objects.requireNonNull(response.body()).string();
        response.close();
        return mapper.readValue(responseBodyString, clazz);
    }


    public static String cookie = "uev2.id.xp=4dc15b9d-9f27-421c-8f1b-a4c4510bd677; dId=a6d90676-7bb1-40dc-838c-a54160d8c338; uev2.id.session=3702c82d-27cc-41ae-a089-fab77c3d19ee; uev2.ts.session=1700170817710; gclid=Cj0KCQiAmNeqBhD4ARIsADsYfTc2wAfKazlpBG9Ct4eB1BzLw2p-eXlVvutPVf6MoaagLFXJw51nFtIaAi7uEALw_wcB; gclsrc=aw.ds; marketing_vistor_id=0530db80-c749-431d-9f5e-b09fec4b78be; uev2.gg=true; utag_main__sn=1; utag_main_ses_id=1700170819595%3Bexp-session; utm_medium=undefined; fm_conversion_id=undefined; utm_source=AdWords_Brand; CONSENTMGR=c1:1%7Cc2:1%7Cc3:1%7Cc4:1%7Cc5:1%7Cc6:1%7Cc7:1%7Cc8:1%7Cc9:1%7Cc10:1%7Cc11:1%7Cc12:1%7Cc13:1%7Cc14:1%7Cc15:1%7Cts:1700170819611%7Cconsent:true; utag_main__ss=0%3Bexp-session; _scid=74974d6b-f723-4d5e-a248-ac022726f61f; _fbp=fb.1.1700170820315.878887548; _gid=GA1.2.1228589961.1700170821; _gac_UA-60706425-3=1.1700170821.Cj0KCQiAmNeqBhD4ARIsADsYfTc2wAfKazlpBG9Ct4eB1BzLw2p-eXlVvutPVf6MoaagLFXJw51nFtIaAi7uEALw_wcB; _tt_enable_cookie=1; _ttp=GGVoKVv_LqCQDpQNFCD9ycxpdp0; _gcl_au=1.1.2064309177.1700170821; _yjsu_yjad=1700170821.92dc122e-bbfc-43d0-afc0-41532bd8e9b6; _sctr=1%7C1700085600000; _gcl_aw=GCL.1700170841.Cj0KCQiAmNeqBhD4ARIsADsYfTc2wAfKazlpBG9Ct4eB1BzLw2p-eXlVvutPVf6MoaagLFXJw51nFtIaAi7uEALw_wcB; _gcl_dc=GCL.1700170841.Cj0KCQiAmNeqBhD4ARIsADsYfTc2wAfKazlpBG9Ct4eB1BzLw2p-eXlVvutPVf6MoaagLFXJw51nFtIaAi7uEALw_wcB; uev2.loc=%7B%22address%22%3A%7B%22address1%22%3A%22McDonald's%C2%AE%2C%20Redhill%22%2C%22address2%22%3A%221200%20Chris%20Hani%20Rd%2C%20Red%20Hill%2C%204051%2C%20ZA%22%2C%22aptOrSuite%22%3A%22%22%2C%22eaterFormattedAddress%22%3A%221200%20Chris%20Hani%20Rd%2C%20Red%20Hill%2C%204051%2C%20ZA%22%2C%22subtitle%22%3A%221200%20Chris%20Hani%20Rd%2C%20Red%20Hill%2C%204051%2C%20ZA%22%2C%22title%22%3A%22McDonald's%C2%AE%2C%20Redhill%22%2C%22uuid%22%3A%22%22%7D%2C%22latitude%22%3A-29.7664669%2C%22longitude%22%3A31.027055%2C%22reference%22%3A%229eb2c4e5-021b-add0-c55a-c8961823184c%22%2C%22referenceType%22%3A%22uber_places%22%2C%22type%22%3A%22uber_places%22%2C%22addressComponents%22%3A%7B%22city%22%3A%22%22%2C%22countryCode%22%3A%22ZA%22%2C%22firstLevelSubdivisionCode%22%3A%22%22%2C%22postalCode%22%3A%224051%22%7D%2C%22categories%22%3A%5B%22SHOPS_AND_SERVICES%22%2C%22RESTAURANT%22%2C%22point_of_interest%22%2C%22FOOD_AND_BEVERAGE%22%5D%2C%22originType%22%3A%22user_autocomplete%22%2C%22source%22%3A%22manual_auto_complete%22%7D; mcd_restaurant=McDonald'sÂ®, Red Hill; jwt-session=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9fand0X3JwY19wcm90ZWN0aW9uX2V4cGlyZXNfYXRfbXMiOjE3MDAyNTY4ODM4MjYsIl9fand0X3JwY19wcm90ZWN0aW9uX3V1aWQiOiI1NjU5Mzc0My00M2VkLTRkMjgtYTdjYy05ZWU4NWQ3ZTI3YmUiLCJfX2p3dF9ycGNfcHJvdGVjdGlvbl9jcmVhdGVkX2F0X21zIjoxNzAwMTcwODE3NzMwfSwiaWF0IjoxNzAwMTcwODE3LCJleHAiOjE3MDAyNTcyMTd9.0hSz2qEcBeAdjQtNBKuHoJeNDBCssWz-DvbysH4fqmA; utag_main__pn=2%3Bexp-session; _scid_r=74974d6b-f723-4d5e-a248-ac022726f61f; _ga=GA1.2.1049867147.1700170821; _gat_tealium_0=1; u.bdc=34054b1e868fdd4de16d2284b4799fdc:95ayG/MuRxeU7yUL:EaBm2x92dG6kGXNyAUrBjBX3btSZVFGAcz+0ynC5S0ffvZSf:MUwTmmcB8UsB9anbcHTkPg==; _userUuid=; _ga_P1RM71MPFP=GS1.1.1700170820.1.1.1700171071.57.0.0; utag_main__se=22%3Bexp-session; utag_main__st=1700172905003%3Bexp-session; _uetsid=bdff660084c811eeb1217b48a7f5f821; _uetvid=bdff88b084c811eeb6df679574e393bb";

}
