package co.za.izinga.menuupdater.responsehandlers;

import okhttp3.Call;
import okhttp3.Callback;

import java.io.IOException;

public interface OkHttpCallBack extends Callback {

    @Override
    default void onFailure(Call call, IOException e) {
        e.printStackTrace();
    }
}
