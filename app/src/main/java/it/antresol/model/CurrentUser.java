package it.antresol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 3/18/15.
 */
public class CurrentUser {

    @SerializedName("social_profiles")
    @Expose
    private List<SocialProfile> mListSocialProfiles;

    @Expose
    private String username;

    @SerializedName("access_token")
    @Expose
    private String accessToken;

    @SerializedName("user_id")
    @Expose
    private long userId;

    @Expose
    private double lat;
    @Expose
    private double lon;
    @Expose
    private String phone;
    @Expose
    private String avatar;

    @SerializedName("created_at")
    @Expose
    private long createAt;


    @SerializedName("likes")
    @Expose
    private List<Like> mLikeList;
    @Expose
    private int sex;


    @SerializedName("country_id")
    @Expose
    private long countryId;

    public CurrentUser() {

    }

    public CurrentUser(List<SocialProfile> mListSocialProfiles, String username, String accessToken, long userId, double lat,
                       double lon, String phone, String avatar, long createAt, List<Like> mLikeList, int sex, long countryId) {

        this.mListSocialProfiles = mListSocialProfiles;
        this.username = username;
        this.accessToken = accessToken;
        this.userId = userId;
        this.lat = lat;
        this.lon = lon;
        this.phone = phone;
        this.avatar = avatar;
        this.createAt = createAt;
        this.mLikeList = mLikeList;
        this.sex = sex;
        this.countryId = countryId;
    }

    public List<SocialProfile> getmListSocialProfiles() {
        return mListSocialProfiles;
    }

    public void setmListSocialProfiles(List<SocialProfile> mListSocialProfiles) {
        this.mListSocialProfiles = mListSocialProfiles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public List<Like> getmLikeList() {
        return mLikeList;
    }

    public void setmLikeList(List<Like> mLikeList) {
        this.mLikeList = mLikeList;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {

        return "CurrentUser{" +
                "mListSocialProfiles=" + mListSocialProfiles +
                ", username='" + username + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", userId=" + userId +
                ", lat=" + lat +
                ", lon=" + lon +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createAt=" + createAt +
                ", mLikeList=" + mLikeList +
                ", sex=" + sex +
                ", countryId=" + countryId +
                '}';
    }
}
