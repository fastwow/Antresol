package antresol.it.antresol.model;

import com.google.gson.annotations.Expose;

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
    private long lat;

    @Expose
    private long lon;

    @Expose
    private long createAt;

    @Expose
    private long adId;

    @Expose
    private User user;

    @Expose
    private long rank;

    @Expose
    private long categoryId;

    @Expose
    private long countryId;

    @Expose
    private long likesCount;

    @Expose
    private int isDelete;

    @Expose
    private int isDeactivated;

    @Expose
    private long commentsCount;

    @Expose
    private List<Image> imageList;

    @Expose
    private List<Comment> commentList;

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

    public long getLat() {

        return lat;
    }

    public void setLat(long lat) {

        this.lat = lat;
    }

    public long getLon() {

        return lon;
    }

    public void setLon(long lon) {

        this.lon = lon;
    }

    public long getCreateAt() {

        return createAt;
    }

    public void setCreateAt(long createAt) {

        this.createAt = createAt;
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

    public long getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }

    public int getIsDelete() {

        return isDelete;
    }

    public void setIsDelete(int isDelete) {

        this.isDelete = isDelete;
    }

    public int getIsDeactivated() {

        return isDeactivated;
    }

    public void setIsDeactivated(int isDeactivated) {

        this.isDeactivated = isDeactivated;
    }

    public long getCommentsCount() {

        return commentsCount;
    }

    public void setCommentsCount(long commentsCount) {

        this.commentsCount = commentsCount;
    }

    public List<Image> getImageList() {

        return imageList;
    }

    public void setImageList(List<Image> imageList) {

        this.imageList = imageList;
    }

    public List<Comment> getCommentList() {

        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {

        this.commentList = commentList;
    }
}
