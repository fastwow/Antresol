package it.antresol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 3/29/15.
 */
public class LikeResponse {

    @SerializedName("data")
    @Expose
    private Like like;

    public LikeResponse() {
    }

    public LikeResponse(Like like) {

        this.like = like;
    }

    public void setLike(Like like) {

        this.like = like;
    }

    public Like getLike() {

        return like;
    }
}
