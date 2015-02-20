package it.antresol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 2/18/15.
 */
public class GetAds extends BaseModel {


    @SerializedName("data")
    @Expose
    private List<Ad> data;

    @SerializedName("_meta")
    @Expose
    private Meta meta;

    @SerializedName("_links")
    @Expose
    private Links links;

    public GetAds() {

    }

    public GetAds(List<Ad> data, Meta meta, Links links) {

        this.data = data;
        this.meta = meta;
        this.links = links;
    }

    public List<Ad> getData() {

        return data;
    }

    public void setData(List<Ad> data) {

        this.data = data;
    }

    public Meta getMeta() {

        return meta;
    }

    public void setMeta(Meta meta) {

        this.meta = meta;
    }

    public Links getLinks() {

        return links;
    }

    public void setLinks(Links links) {

        this.links = links;
    }

    @Override
    public String toString() {

        return "GetAds{" +
                "data=" + data +
                ", meta=" + meta +
                ", links=" + links +
                '}';
    }
}
