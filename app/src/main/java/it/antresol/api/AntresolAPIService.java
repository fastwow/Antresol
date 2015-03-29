package it.antresol.api;

import org.json.JSONObject;

import it.antresol.model.AddLikeBody;
import it.antresol.model.CreateUserBody;
import it.antresol.model.CreateUserResponse;
import it.antresol.model.GetAds;
import it.antresol.model.CurrentUser;
import it.antresol.model.Like;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Header;
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
    void addLike(@Header("Authorization") String authorization, @Body AddLikeBody likedBody, Callback<Like> results);

    @DELETE("/likes")
    void deleteLike(@Header("Authorization") String authorization, @Body AddLikeBody likedBody, Callback<Like> results);

    @POST("/users")
    void createUser(@Body CreateUserBody user, Callback<CreateUserResponse> results);
}
