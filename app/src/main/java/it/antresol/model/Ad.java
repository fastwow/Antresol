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

    public Ad() {

    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public long getPrice() {

        return price;
    }

    public void setPrice(long price) {

        this.price = price;
    }

    public double getLat() {

        return lat;
    }

    public void setLat(double lat) {

        this.lat = lat;
    }

    public double getLon() {

        return lon;
    }

    public void setLon(double lon) {

        this.lon = lon;
    }

    public long getCreateAt() {

        return createAt;
    }

    public void setCreateAt(long createAt) {

        this.createAt = createAt;
    }

    public long getUpdatedAt() {

        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {

        this.updatedAt = updatedAt;
    }

    public String getDeleteReason() {

        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {

        this.deleteReason = deleteReason;
    }

    public int getSex() {

        return sex;
    }

    public void setSex(int sex) {

        this.sex = sex;
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

    public long getRank() {

        return rank;
    }

    public void setRank(long rank) {

        this.rank = rank;
    }

    public long getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(long categoryId) {

        this.categoryId = categoryId;
    }

    public long getCountryId() {

        return countryId;
    }

    public void setCountryId(long countryId) {

        this.countryId = countryId;
    }

    public int getLikesCount() {

        return likesCount;
    }

    public void setLikesCount(int likesCount) {

        this.likesCount = likesCount;
    }

    public int getIsDelete() {

        return isDelete;
    }

    public void setIsDelete(int isDelete) {

        this.isDelete = isDelete;
    }

    public String getIsDeactivated() {

        return isDeactivated;
    }

    public void setIsDeactivated(String isDeactivated) {

        this.isDeactivated = isDeactivated;
    }

    public long getCommentsCount() {

        return commentsCount;
    }

    public void setCommentsCount(long commentsCount) {

        this.commentsCount = commentsCount;
    }

    public Image getImage() {

        return image;
    }

    public void setImage(Image image) {

        this.image = image;
    }

    public List<Image> getImageList() {

        return imageList;
    }

    public void setImageList(List<Image> imageList) {

        this.imageList = imageList;
    }

    public List<Comment> getFirstThreeCommentList() {

        return firstThreeCommentList;
    }

    public void setFirstThreeCommentList(List<Comment> firstThreeCommentList) {

        this.firstThreeCommentList = firstThreeCommentList;
    }
}
