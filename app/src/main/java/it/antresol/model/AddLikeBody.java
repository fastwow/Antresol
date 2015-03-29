package it.antresol.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 3/29/15.
 */
public class AddLikeBody {

    @SerializedName("ad_id")
    private long adId;

    public AddLikeBody(long adId) {

        this.adId = adId;
    }

    public AddLikeBody() {

    }

    public void setAdId(long adId) {

        this.adId = adId;
    }

    public long getAdId() {

        return adId;
    }
}
