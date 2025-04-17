package co.za.izinga.menuupdater.service;

import co.za.izinga.menuupdater.Application;
import co.za.izinga.menuupdater.model.Promotion;
import co.za.izinga.menuupdater.model.Stock;
import co.za.izinga.menuupdater.model.StoreProfile;
import co.za.izinga.menuupdater.model.StoreType;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class IzingaService {

    private static Logger log = LoggerFactory.getLogger(IzingaService.class);
    private static List<String> promos = new ArrayList<>();
    private static final Random rand = new Random();

    public static boolean updateStoreOnIzinga(StoreProfile steersStore) {
        try {
            steersStore.setScheduledDeliveryAllowed(false);
            steersStore.setHasPaymentAgreement(true);
            //sort stock so that it appears correctly on the app, promos first
            ArrayList<Stock> sorted = new ArrayList<>(steersStore.getStockList());
            steersStore.setStockList(new HashSet<>(sorted));
            //update store menu
            String storesUrl = Application.izingaUrl + "/store/" + steersStore.getId();
            RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"),
                    Application.mapper.writeValueAsString(steersStore));
            ;
            Request request = new Request.Builder().url(storesUrl)
                    .patch(body)
                    .build();
            Application.client.newCall(request).execute().close();

            //update promotions
            if (!steersStore.isStoreOffline() || promos.contains(steersStore.getFranchiseName())) return false;
            steersStore.getStockList()
                    .stream()
                    .filter(IzingaService::isAPromo)
                    .map(stock -> {
                        var promo = new Promotion(stock.getImages().get(0), steersStore.getId(),
                                StoreType.FOOD, Date.from(LocalDateTime.now().plusHours(4).toInstant(ZoneOffset.UTC)));
                        promo.setMessage(stock.getDescription());
                        promo.setTitle(stock.getName());
                        return promo;
                    })
                    .forEach(promotion -> {
                        try {
                            String promoUrl = Application.izingaUrl + "/promotion/";
                            RequestBody promoBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"),
                                    Application.mapper.writeValueAsString(promotion));
                            Request promoRequest = new Request.Builder().url(promoUrl)
                                    .post(promoBody)
                                    .build();
                            Application.client.newCall(promoRequest).execute().close();
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                        }
                    });
            promos.add(steersStore.getFranchiseName());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return true;
    }

    private static boolean isAPromo(Stock stock) {
        var promoGroups = List.of("deal", "special", "promotion", "promotions", "deals", "specials", "family meals", "featured items");
        return stock.getGroup() != null && promoGroups.contains(stock.getGroup().toLowerCase());
    }
}