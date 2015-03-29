package it.antresol.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 3/29/15.
 */
public class LikeBody {

    @SerializedName("ad_id")
    private long adId;

    public LikeBody(long adId) {

        this.adId = adId;
    }

    public LikeBody() {

    }

    public void setAdId(long adId) {

        this.adId = adId;
    }

    public long getAdId() {

        return adId;
    }
}
