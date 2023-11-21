package co.za.izinga.menuupdater;

import co.za.izinga.menuupdater.chickenlicken.CLMenuToIzinga;
import co.za.izinga.menuupdater.kfc.KfcToIzingaMenu;
import co.za.izinga.menuupdater.mcdonals.McDonaldsToIzinga;
import co.za.izinga.menuupdater.model.StoreProfile;
import co.za.izinga.menuupdater.nandos.NandosToIzinga;
import co.za.izinga.menuupdater.service.IzingaService;
import co.za.izinga.menuupdater.steers.SteersMenuToIzinga;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Application {

    public static final String STEERS_URL = "https://app.steers.co.za/management/api";
    public static final String DEBON_URL = "https://app.debonairspizza.co.za/management/api";
    public static final String PEDROS_URL = "https://app.pedroschicken.co.za/management/api";
    public static final String WIMPY_URL = "https://app.wimpy.co.za/management/api";
    public static final String FISHAWAYS = "https://app.fishaways.co.za/management/api";
    /*public static final String izingaUrl = "https://api-uat.izinga.co.za";
    public static final String ownerId = "6c45f9e0-dd55-4059-870c-08d578a259e6";*/
    public static final String izingaUrl = "https://api.izinga.co.za";
    public static final String ownerId = "650f5078-10aa-4f98-b6e3-eac2fbd276ad";
    public static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(Duration.ofSeconds(30))
            .callTimeout(Duration.ofSeconds(30))
            .build();
    public static final ObjectMapper mapper  = new ObjectMapper()
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"))
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    public static void main(String[] args) throws IOException {
        String storesUrl = izingaUrl + "/store?latitude=0&longitude=0&ownerId="+ownerId+"&range=100&size=100&storeType=FOOD";
        Request request = new Request.Builder().url(storesUrl).build();
        Response response = Objects.requireNonNull(client.newCall(request).execute());
        byte[] responseBodyBytes =  Objects.requireNonNull(response.body()).bytes();
        List<StoreProfile> izingaStores = mapper.readValue(responseBodyBytes, new TypeReference<>() {});
        response.close();
        System.out.println("Starting menu update....");

        //Steers
        izingaStores.stream()
                .filter(store -> store.getName().toLowerCase().contains("steers"))
                .forEach(steersStore -> {
                    try {
                        SteersMenuToIzinga.loadSteersMidWay(steersStore);
                        //update store on izinga
                        IzingaService.updateStoreOnIzinga(steersStore);
                        System.out.println("Steers");
                        System.out.println(mapper.writeValueAsString(steersStore));
                        System.out.println("=============");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        //Steers
        izingaStores.stream()
                .filter(store -> store.getName().toLowerCase().contains("debonairs"))
                .forEach(debonairsStore -> {
                    try {
                        SteersMenuToIzinga.loadDeboniarsMidway(debonairsStore);
                        //update store on izinga
                        IzingaService.updateStoreOnIzinga(debonairsStore);
                        System.out.println("Debonairs");
                        System.out.println(mapper.writeValueAsString(debonairsStore));
                        System.out.println("=============");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        //pedros
        izingaStores.stream()
                .filter(store -> store.getName().toLowerCase().contains("pedro"))
                .forEach(pedrosStore -> {
                    try {
                        SteersMenuToIzinga.loadPedrosMidway(pedrosStore);
                        //update store on izinga
                        IzingaService.updateStoreOnIzinga(pedrosStore);
                        System.out.println("Pedros");
                        System.out.println(mapper.writeValueAsString(pedrosStore));
                        System.out.println("=============");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        //Chicken licken
        izingaStores.stream()
                .filter(store -> store.getName().toLowerCase().contains("chicken licken"))
                .forEach(chickenLickenStore -> {
                    try {
                        CLMenuToIzinga.loadChickenLMenu(chickenLickenStore);
                        //update store on izinga
                        IzingaService.updateStoreOnIzinga(chickenLickenStore);
                        System.out.println(chickenLickenStore.getName());
                        System.out.println(mapper.writeValueAsString(chickenLickenStore));
                        System.out.println("=============");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });


        //Nandos
        izingaStores.stream()
                .filter(store -> store.getName().toLowerCase().contains("nandos"))
                .forEach(nandosStore -> {
                    try {
                        NandosToIzinga.loadNandosLMenu(nandosStore);
                        //update store on izinga
                        IzingaService.updateStoreOnIzinga(nandosStore);
                        System.out.println(nandosStore.getName());
                        var writer = new FileWriter(nandosStore.getName() + ".json");
                        writer.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nandosStore));
                        writer.close();
                        System.out.println("=============");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        //wimpy
        izingaStores.stream()
                .filter(store -> store.getName().toLowerCase().contains("wimpy"))
                .forEach(wimpyStore -> {
                    try {
                        SteersMenuToIzinga.loadWimpy(wimpyStore);
                        //update store on izinga
                        IzingaService.updateStoreOnIzinga(wimpyStore);
                        System.out.println(wimpyStore.getName());
                        System.out.println(mapper.writeValueAsString(wimpyStore));
                        System.out.println("=============");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        //fishaways
        izingaStores.stream()
                .filter(store -> store.getName().toLowerCase().contains("fishaways"))
                .forEach(fishaways -> {
                    try {
                        SteersMenuToIzinga.loadFishaways(fishaways);
                        //update store on izinga
                        IzingaService.updateStoreOnIzinga(fishaways);
                        System.out.println(fishaways.getName());
                        System.out.println(mapper.writeValueAsString(fishaways));
                        System.out.println("=============");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });


        //kfc
        izingaStores.stream()
                .filter(store -> store.getName().toLowerCase().contains("kfc"))
                .forEach(kfc -> {
                    try {
                        KfcToIzingaMenu.loadKfcMenu(kfc);
                        //update store on izinga
                        IzingaService.updateStoreOnIzinga(kfc);
                        System.out.println(kfc.getName());
                        System.out.println(mapper.writeValueAsString(kfc));
                        System.out.println("=============");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        //mcdonals
        izingaStores.stream()
                .filter(store -> store.getName().toLowerCase().contains("mcdonald"))
                .forEach(mcd -> {
                    try {
                        McDonaldsToIzinga.loadMcdonalsMenu(mcd);
                        //update store on izinga
                        IzingaService.updateStoreOnIzinga(mcd);
                        System.out.println(mcd.getName());
                        System.out.println(mapper.writeValueAsString(mcd));
                        System.out.println("=============");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        Objects.requireNonNull(response.body()).close();

    }
}
