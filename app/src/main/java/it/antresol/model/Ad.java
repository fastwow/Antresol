package it.antresol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 2/12/15.
 */
public class Ad extends BaseModel {

    @Expose
    private String title;

    @Expose
    private String desc;

    @Expose
    private long price;

    @Expose
    private double lat;

    @Expose
    private double lon;

    @SerializedName("created_at")
    @Expose
    private long createAt;

    @SerializedName("updated_at")
    @Expose
    private long updatedAt;

    @SerializedName("delete_reason")
    @Expose
    private String deleteReason;

    @Expose
    private int sex;

    @SerializedName("ad_id")
    @Expose
    private long adId;

    @Expose
    private User user;

    @Expose
    private long rank;

    @SerializedName("category_id")
    @Expose
    private long categoryId;

    @SerializedName("country_id")
    @Expose
    private long countryId;

    @SerializedName("likes_count")
    @Expose
    private int likesCount;

    @SerializedName("is_delete")
    @Expose
    private int isDelete;

    @SerializedName("is_deactivated")
    @Expose
    private String isDeactivated;

    @SerializedName("comments_count")
    @Expose
    private long commentsCount;

    @Expose
    private Image image;

    @SerializedName("images")
    @Expose
    private List<Image> imageList;

    @SerializedName("first_three_comments")
    @Expose
    private List<Comment> firstThreeCommentList;
}
