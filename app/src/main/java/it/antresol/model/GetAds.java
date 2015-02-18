package it.antresol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 2/18/15.
 */
public class GetAds {


    @SerializedName("data")
    @Expose
    private List<Ad> data;

    @SerializedName("_meta")
    @Expose
    private Meta meta;

    @SerializedName("_links")
    @Expose
    private Links links;
}
