package it.antresol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 2/12/15.
 */
public class Like extends BaseModel {

    @SerializedName("ad_id")
    @Expose
    private long adId;

    @SerializedName("user_id")
    @Expose
    private long userId;

    @SerializedName("created_at")
    @Expose
    private long createdAt;

    public Like(long adId, long userId) {

        this.adId = adId;
        this.userId = userId;
    }

    public Like(long adId, long userId, long createdAt) {

        this.adId = adId;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public long getAdId() {

        return adId;
    }

    public void setAdId(long adId) {

        this.adId = adId;
    }

    public long getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(long createdAt) {

        this.createdAt = createdAt;
    }

    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    @Override
    public String toString() {

        return "Like{" +
                "adId=" + adId +
                ", userId=" + userId +
                ", createdAt=" + createdAt +
                '}';
    }

    public int hashCode() {

        long hash = 17;
        hash = hash * 31 + adId;
        hash = hash * 31 + userId;

        return (int) hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Like))
            return false;

        if (obj == this)
            return true;

        Like rhs = (Like) obj;
        return (adId == rhs.getAdId()) && (userId == rhs.getUserId());
    }
}
