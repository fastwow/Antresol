package it.antresol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 2/12/15.
 */
public class Comment extends BaseModel {

    @Expose
    private String message;

    @SerializedName("ad_id")
    @Expose
    private long adId;

    @Expose
    private User user;

    @SerializedName("created_at")
    @Expose
    private long createAt;

    @SerializedName("comment_id")
    @Expose
    private long commentId;

    public Comment() {

    }

    public Comment(String message, long adId, User user, long createAt, long commentId) {

        this.message = message;
        this.adId = adId;
        this.user = user;
        this.createAt = createAt;
        this.commentId = commentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }
}
