package antresol.it.antresol.api;

import antresol.it.antresol.model.Ad;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by artem on 2/16/15.
 */
public interface AntresolAPI {

    String DEV_SERVER_VERSION = "v1";
    String DEV_BASE_URL = "http://dev-api.antresol.it/" + DEV_SERVER_VERSION;

    String SERVER_VERSION = "v1";
    String BASE_URL = "http://api.antresol.it/" + SERVER_VERSION;

    @GET("/ads")
    void getAdList(Callback<Ad> results);
}
