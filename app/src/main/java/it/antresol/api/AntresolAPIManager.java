package it.antresol.api;

import android.content.Context;
import android.util.Log;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.List;

import it.antresol.model.Ad;
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

    private static final String FIRST_PAGE = "1";

    private static AntresolAPIManager mInstance;

    //Singleton Instance of our Rest Client
    private AntresolAPIService mAntresolAPIServiceService;
    private Context mContext;

    private GetAds mGetAds = null;

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

    private String getNumPage(String url) {

        return url.split("page=")[1];
    }

    public void getAdList(final boolean isNeedToLoadStartPage, final IRequestStatusListener listener) {

        final String numPage;
        if (isNeedToLoadStartPage || mGetAds == null) {

            numPage = FIRST_PAGE;
        } else {

            if (mGetAds.getMeta().getCurrentPage() <= mGetAds.getMeta().getTotalCount()) {

                numPage = getNumPage(mGetAds.getLinks().getNext().getHref());
            } else {

                numPage = "";
                if (listener != null)
                    listener.onSuccess(null);
            }
        }
        mAntresolAPIServiceService.getAdList(numPage, new Callback<GetAds>() {

            @Override
            public void success(GetAds result, Response response) {

                try {

                    if (mGetAds == null)
                        mGetAds = result;
                    else {

                        List<Ad> prevPageAdList = mGetAds.getData();
                        mGetAds = result;
                        if (!isNeedToLoadStartPage) {

                            mGetAds.getData().addAll(prevPageAdList);
                        }
                        prevPageAdList = null;
                    }

                    if (listener != null)
                        listener.onSuccess(mGetAds);
                } catch (Throwable th) {

                    Log.e(TAG, "failed! ", th);
                    if (listener != null)
                        listener.onError();
                }
            }

            @Override
            public void failure(RetrofitError error) {

                if (listener != null)
                    listener.onError();
            }
        });
    }
}
