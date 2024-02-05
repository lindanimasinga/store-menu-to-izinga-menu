package co.za.izinga.menuupdater;

import co.za.izinga.menuupdater.bp.BPToIzinga;
import co.za.izinga.menuupdater.chickenlicken.CLMenuToIzinga;
import co.za.izinga.menuupdater.kfc.KfcToIzingaMenu;
import co.za.izinga.menuupdater.mcdonals.McDonaldsToIzinga;
import co.za.izinga.menuupdater.model.StoreProfile;
import co.za.izinga.menuupdater.nandos.NandosToIzinga;
import co.za.izinga.menuupdater.service.IzingaService;
import co.za.izinga.menuupdater.spur.SpurToIzinga;
import co.za.izinga.menuupdater.steers.SteersMenuToIzinga;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
            .connectTimeout(Duration.ofMinutes(2))
            .callTimeout(Duration.ofMinutes(2))
            .connectionPool(new ConnectionPool(10, 2, TimeUnit.MINUTES))
            .build();
    public static final ObjectMapper mapper  = new ObjectMapper()
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"))
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    public static void main(String[] args) throws IOException {
        System.out.println("Fetching all store on izinga....");
        String storesUrl = izingaUrl + "/store?latitude=0&longitude=0&ownerId="+ownerId+"&range=100&size=100&storeType=FOOD";
        Request request = new Request.Builder().url(storesUrl).build();
        Response response = Objects.requireNonNull(client.newCall(request).execute());
        byte[] responseBodyBytes =  Objects.requireNonNull(response.body()).bytes();
        List<StoreProfile> izingaStores = mapper.readValue(responseBodyBytes, new TypeReference<>() {});
        response.close();
        System.out.println("Starting menu update....");

        var executor = Executors.newFixedThreadPool(5);
        izingaStores.stream()
                //.filter(store -> store.getName().toLowerCase().contains("bp"))
                .forEach(mcd -> executor.execute(() -> updateStore(mcd)));
    }

    private static void updateStore(StoreProfile mcd) {
        try {
            var loaded = loadStore(mcd);
            if(!loaded) return;
            //update store on izinga
            IzingaService.updateStoreOnIzinga(mcd);
            System.out.println(mcd.getName());
            System.out.println(mapper.writeValueAsString(mcd));
            System.out.println("=============");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean loadStore(StoreProfile store) throws IOException, URISyntaxException {
        if (store.getName().toLowerCase().contains("debonairs")) SteersMenuToIzinga.loadDeboniarsMidway(store);
        else if (store.getName().toLowerCase().contains("steers")) SteersMenuToIzinga.loadSteersMidWay(store);
        else if (store.getName().toLowerCase().contains("pedro")) SteersMenuToIzinga.loadPedrosMidway(store);
        else if (store.getName().toLowerCase().contains("chicken licken")) CLMenuToIzinga.loadChickenLMenu(store);
        else if (store.getName().toLowerCase().contains("nandos")) NandosToIzinga.loadNandosLMenu(store);
        else if (store.getName().toLowerCase().contains("wimpy")) SteersMenuToIzinga.loadWimpy(store);
        else if (store.getName().toLowerCase().contains("fishaways")) SteersMenuToIzinga.loadFishaways(store);
        else if (store.getName().toLowerCase().contains("kfc")) KfcToIzingaMenu.loadKfcMenu(store);
        else if (store.getName().toLowerCase().contains("mcdonald")) McDonaldsToIzinga.loadMcdonalsMenu(store);
        else if (store.getName().toLowerCase().contains("spur")) SpurToIzinga.loadSpurMenu(store);
        else if (store.getName().toLowerCase().contains("bp")) BPToIzinga.loadBpMenu(store);
        else return false;
        return true;
    }
}
