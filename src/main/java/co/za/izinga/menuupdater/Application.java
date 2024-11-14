package co.za.izinga.menuupdater;

import co.za.izinga.menuupdater.bp.BPToIzinga;
import co.za.izinga.menuupdater.chickenlicken.CLMenuToIzinga;
import co.za.izinga.menuupdater.izingamancare.ShopriteMenToIzinga;
import co.za.izinga.menuupdater.kfc.KfcToIzingaMenu;
import co.za.izinga.menuupdater.mcdonals.McDonaldsToIzinga;
import co.za.izinga.menuupdater.medirite.MediriteToIzinga;
import co.za.izinga.menuupdater.model.Stock;
import co.za.izinga.menuupdater.model.StoreProfile;
import co.za.izinga.menuupdater.nandos.NandosToIzinga;
import co.za.izinga.menuupdater.service.IzingaService;
import co.za.izinga.menuupdater.shoprite.ShopriteToIzinga;
import co.za.izinga.menuupdater.spur.SpurToIzinga;
import co.za.izinga.menuupdater.steers.SteersMenuToIzinga;
import co.za.izinga.menuupdater.woolworths.WoolworthsToIzinga;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static co.za.izinga.menuupdater.RemoteImageService.convertAndUploadImages;

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
            .connectionPool(new ConnectionPool(70, 2, TimeUnit.MINUTES))
            .build();

    public static final ObjectMapper mapper = new ObjectMapper()
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"))
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    static ExecutorService executor = Executors.newFixedThreadPool(20);

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) throws IOException, InterruptedException {
        log.info("Fetching all store on izinga....");
        String storesUrl = izingaUrl + "/store?latitude=0&longitude=0&ownerId=" + ownerId + "&range=100&size=100&storeType=FOOD";
        Request request = new Request.Builder().url(storesUrl).build();
        Response response = Objects.requireNonNull(client.newCall(request).execute());
        byte[] responseBodyBytes = Objects.requireNonNull(response.body()).bytes();
        response.close();
        final List<StoreProfile> izingaStores = mapper.readValue(responseBodyBytes, new TypeReference<List<StoreProfile>>() {
                })
                .stream()
                .filter(store -> !store.getName().toLowerCase().contains("shoprite")
                        && !store.getName().toLowerCase().contains("medirite")
                        && !store.getName().toLowerCase().contains("izinga mencare"))
                .toList();


        log.info("Starting menu update....");
        getBulkExecute(izingaStores.stream(), Application::updateStore);

        log.info("waiting for s3 image upload completion");
        Stream<Map.Entry<String, Stock>> shopStock = izingaStores.stream()
                .flatMap(store -> store.getStockList().stream().map(st -> Map.entry(store.getName(), st)));

        getBulkExecute(shopStock, ((Map.Entry<String, Stock> stock) -> {
            return Optional.ofNullable(stock.getValue().getImages())
                    .filter(images -> !images.isEmpty())
                    .map(images -> images.get(0))
                    .map(oldUrl -> {
                        var newUrl = oldUrl.contains("amazonaws") ? oldUrl.replace("AF_SOUTH_1", "af-south-1") :
                                convertAndUploadImages(stock.getKey(), stock.getValue().getImages().get(0));
                        stock.getValue().setImages(List.of(newUrl));
                        return newUrl;
                    })
                    .orElse("");
        }));

        log.info("Update stores with new image urls");
        getBulkExecute(izingaStores.stream(), IzingaService::updateStoreOnIzinga);
    }

    private static boolean updateStore(StoreProfile mcd) {
        try {
            var loaded = loadStore(mcd);
            if (!loaded) return loaded;
            //update store on izinga
            IzingaService.updateStoreOnIzinga(mcd);
            log.info(mcd.getName());
            log.info(mapper.writeValueAsString(mcd));
            log.info("=============");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return true;
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
        else if (store.getName().toLowerCase().contains("woolworths")) WoolworthsToIzinga.loadWWMenu(store);
        else if (store.getName().toLowerCase().contains("shoprite")) ShopriteToIzinga.loadWWMenu(store);
        else if (store.getName().toLowerCase().contains("medirite")) MediriteToIzinga.loadWWMenu(store);
        else if (store.getName().toLowerCase().contains("izinga mencare")) ShopriteMenToIzinga.loadWWMenu(store);
        else return false;
        return true;
    }

    static <A, B> void getBulkExecute(Stream<A> data, Function<A, B> execute) throws InterruptedException {
        var menuUpdateCallable = data
                .map(mcd -> (Callable<B>) () -> execute.apply(mcd)).toList();
        executor.invokeAll(menuUpdateCallable).forEach(status -> {
            try {
                status.get();
                log.info("store update completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
