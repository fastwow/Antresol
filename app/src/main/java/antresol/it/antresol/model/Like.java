package antresol.it.antresol.model;

/**
 * Created by artem on 2/12/15.
 */
public class Like extends BaseModel {

    private long adId;
    private long userId;
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
