package it.antresol.api;

import org.json.JSONObject;

import it.antresol.model.GetAds;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by artem on 2/16/15.
 */
public interface AntresolAPIService {

    String DEV_SERVER_VERSION = "v1";
    String DEV_BASE_URL = "http://dev-api.antresol.it/" + DEV_SERVER_VERSION;

    String SERVER_VERSION = "v1";
    String BASE_URL = "http://api.antresol.it/" + SERVER_VERSION;

    @GET("/ads")
    void getAdList(@Query("page") String numPage, Callback<GetAds> results);

    @POST("/likes")
    void addLikes(@Body JSONObject idId, Callback<GetAds> results);

    @DELETE("/likes")
    void deleteLike(@Body JSONObject idId, Callback<GetAds> results);

}
