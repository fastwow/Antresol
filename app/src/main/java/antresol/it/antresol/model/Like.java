package antresol.it.antresol.model;

import com.google.gson.annotations.Expose;

/**
 * Created by artem on 2/12/15.
 */
public class Like extends BaseModel {

    @Expose
    private long adId;

    @Expose
    private long userId;

    @Expose
    private long createdAt;

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
}
