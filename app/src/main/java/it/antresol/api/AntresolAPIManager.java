package it.antresol.api;

import android.content.Context;
import android.util.Log;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import it.antresol.model.GetAds;
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

    private static final String TAG = AntresolAPIManager.class.getSimpleName();

    private static AntresolAPIManager mInstance;

    //Singleton Instance of our Rest Client
    private AntresolAPIService mAntresolAPIServiceService;
    private Context mContext;

    private AntresolAPIManager(Context context) {

        if (mAntresolAPIServiceService == null) {

            OkHttpClient httpClient = new OkHttpClient();
            try {
                httpClient.setCache(new Cache(context.getCacheDir(), 50 * 1024 * 1024));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Client client = new OkClient(httpClient);

//            GsonBuilder gsonBuilder = new GsonBuilder();
//            gsonBuilder.registerTypeAdapter(Ad.class, new ModelDeserializer<Ad>());
//            Gson gson = gsonBuilder.create();
            RestAdapter adapter = new RestAdapter.Builder().setEndpoint(AntresolAPIService.DEV_BASE_URL)
                    .setClient(client)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
//                    .setConverter(new GsonConverter(gson))
                    .build();

            mAntresolAPIServiceService = adapter.create(AntresolAPIService.class);

            mContext = context;
        }
    }

    public static void init(Context context) {

        if (mInstance == null)
            mInstance = new AntresolAPIManager(context);
    }

    public static AntresolAPIManager getInstance() {

        return mInstance;
    }

    /*
    class ModelDeserializer<T> implements JsonDeserializer<T> {

        @Override
        public T deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
                throws JsonParseException {

            // Get the "content" element from the parsed JSON
            JsonElement content = je.getAsJsonObject().get("data").getAsJsonArray();

            // Deserialize it. You use a new instance of Gson to avoid infinite recursion
            // to this deserializer
            return new Gson().fromJson(content, type);

        }


    }
    */

    public void getAdList() {

        mAntresolAPIServiceService.getAdList(new Callback<GetAds>() {

            @Override
            public void success(GetAds result, Response response) {

                try {

                    //save data
//                    mContext.getContentResolver().bulkInsert(AntresolContentProvider.ADS_CONTENT_URI, BaseModel.toContentValues(ads));
                } catch (Throwable th) {

                    Log.e(TAG, "failed! ", th);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
