package antresol.it.antresol.model;

import com.google.gson.annotations.Expose;

/**
 * Created by artem on 2/12/15.
 */
public class Comment extends BaseModel {

    @Expose
    private String message;

    @Expose
    private long adId;

    @Expose
    private long userId;

    @Expose
    private long createAt;

    @Expose
    private long commentId;

    public Comment(String message, long adId, long createAt, long commentId, long userId) {

        this.message = message;
        this.adId = adId;
        this.createAt = createAt;
        this.commentId = commentId;
        this.userId = userId;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public long getCommentId() {

        return commentId;
    }

    public void setCommentId(long commentId) {

        this.commentId = commentId;
    }

    public long getCreateAt() {

        return createAt;
    }

    public void setCreateAt(long createAt) {

        this.createAt = createAt;
    }

    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    public long getAdId() {

        return adId;
    }

    public void setAdId(long adId) {

        this.adId = adId;
    }
}
