package it.antresol.api;

import android.content.Context;
import android.util.Log;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import it.antresol.model.Ad;
import it.antresol.model.AddLikeBody;
import it.antresol.model.CreateUserBody;
import it.antresol.model.CreateUserResponse;
import it.antresol.model.CurrentUser;
import it.antresol.model.GetAds;
import it.antresol.model.Like;
import it.antresol.model.User;
import it.antresol.utils.UserPreferenceHelper;
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
    private AntresolAPIService mAntresolAPIService;
    private Context mContext;

    private GetAds mGetAds = null;

    private HashMap<Long, User> mCachedUsersMap = null;
    private HashMap<Long, Ad> mCachedAdsMap = null;

    private void initCache() {

        mCachedUsersMap = new HashMap<>();
        mCachedAdsMap = new HashMap<>();
    }

    private AntresolAPIManager(Context context) {

        if (mAntresolAPIService == null) {

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

            mAntresolAPIService = adapter.create(AntresolAPIService.class);

            mContext = context;

            initCache();
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

    public void putUserToCache(User user) {

        if (user != null) {

            mCachedUsersMap.put(Long.valueOf(user.getUserId()), user);
        }
    }

    public void putAdToCache(Ad ad) {

        if (ad != null) {

            mCachedAdsMap.put(Long.valueOf(ad.getAdId()), ad);
        }
    }

    public User getUserFromCache(Long id) {

        return mCachedUsersMap.get(id);
    }

    public Ad getAdFromCache(Long id) {

        return mCachedAdsMap.get(id);
    }

    private void clearCache() {

        mCachedUsersMap.clear();
        mCachedAdsMap.clear();
    }


    private String getNumPage(String url) {

        return url.split("page=")[1];
    }

    public void createUser(final IRequestStatusListener listener, CreateUserBody user) {

        mAntresolAPIService.createUser(user, new Callback<CreateUserResponse>() {

            @Override
            public void success(CreateUserResponse createUserResponse, Response response) {

                if (listener != null)
                    listener.onSuccess(createUserResponse.getCurrentUser());
            }

            @Override
            public void failure(RetrofitError error) {


                if (listener != null)
                    listener.onError();
            }
        });
    }

    public void addLike(final Long likedAdId) {

        mAntresolAPIService.addLike(getAccessTokenValue(),
                new AddLikeBody(likedAdId), new Callback<Like>() {

                    @Override
                    public void success(Like like, Response response) {

                        CurrentUser user = UserPreferenceHelper.getInstance().getCurrentUser();
                        user.getLikeList().add(like);
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
    }

    public void deleteLike(final Long likedAdId) {

        mAntresolAPIService.deleteLike(getAccessTokenValue(), new AddLikeBody(likedAdId), new Callback<Like>() {

            @Override
            public void success(Like like, Response response) {

                CurrentUser user = UserPreferenceHelper.getInstance().getCurrentUser();
                user.getLikeList().remove(like);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void getAdList(final IRequestStatusListener listener, final boolean isNeedToLoadStartPage) {

        final String numPage;
        if (isNeedToLoadStartPage || mGetAds == null) {

            numPage = FIRST_PAGE;
        } else {

            if (mGetAds.getMeta().getCurrentPage() <= mGetAds.getMeta().getTotalCount()) {

                numPage = getNumPage(mGetAds.getLinks().getNext().getHref());
            } else {

                numPage = "";
                if (listener != null)
                    listener.onSuccess(null, false);
            }
        }
        mAntresolAPIService.getAdList(numPage, new Callback<GetAds>() {

            @Override
            public void success(GetAds result, Response response) {

                List<Ad> toResult = null;
                toResult = new LinkedList<Ad>(result.getData());
                if (mGetAds == null) {

                    mGetAds = result;
                    clearCache();
                } else {

                    List<Ad> prevPageAdList = mGetAds.getData();
                    mGetAds = result;
                    if (!isNeedToLoadStartPage) {

                        mGetAds.getData().addAll(prevPageAdList);
                    } else {

                        clearCache();
                    }
                    prevPageAdList = null;
                }
                if (listener != null) {

                    listener.onSuccess(toResult, isNeedToLoadStartPage);
                }
            }

            @Override
            public void failure(RetrofitError error) {

                Log.d(TAG, "getAdList.failure. error = " + error);

                if (listener != null)
                    listener.onError();
            }
        });
    }

    private String getAccessTokenValue() {

        return "Bearer " + UserPreferenceHelper.getInstance().getAccessToken();
    }
}
