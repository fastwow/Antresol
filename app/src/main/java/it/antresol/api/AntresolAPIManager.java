package it.antresol.api;

import android.content.Context;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import it.antresol.model.Ad;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.Response;

/**
 * Created by artem on 2/16/15.
 */
public class AntresolAPIManager {

    private static AntresolAPIManager mInstance;

    //Singleton Instance of our Rest Client
    private AntresolAPI mAntresolAPIService;

    private AntresolAPIManager(Context context) {

        if (mAntresolAPIService == null) {

            OkHttpClient httpClient = new OkHttpClient();
            try {
                httpClient.setCache(new Cache(context.getCacheDir(), 50 * 1024 * 1024));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Client client = new OkClient(httpClient);

            RestAdapter adapter = new RestAdapter.Builder().setEndpoint(AntresolAPI.DEV_BASE_URL)
                    .setClient(client)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            mAntresolAPIService = adapter.create(AntresolAPI.class);
        }
    }

    public static void init(Context context) {

        if (mInstance == null)
            mInstance = new AntresolAPIManager(context);
    }

    public static AntresolAPIManager getInstance() {

        return mInstance;
    }

    private void getAdList() {

        mAntresolAPIService.getAdList(new Callback<Ad>() {

            @Override
            public void success(Ad ad, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {


            }
        });
    }
}
