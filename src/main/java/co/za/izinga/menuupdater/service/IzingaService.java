package co.za.izinga.menuupdater.service;

import co.za.izinga.menuupdater.Application;
import co.za.izinga.menuupdater.model.StoreProfile;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class IzingaService {

    public static void updateStoreOnIzinga(StoreProfile steersStore) throws IOException {
        String storesUrl = Application.izingaUrl + "/store/" + steersStore.getId();
        RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"),
                Application.mapper.writeValueAsString(steersStore));;
        Request request = new Request.Builder().url(storesUrl)
                .patch(body)
                .build();
        Application.client.newCall(request).execute().close();
    }
}