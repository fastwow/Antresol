package it.antresol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 3/18/15.
 */
public class SocialProfile {

    @SerializedName("birthday")
    @Expose
    private String birthday;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("provider_user_id")
    @Expose
    private String providerUserId;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @Expose
    private String provider;

    @Expose
    private String avatar;

    public SocialProfile() {

    }

    public SocialProfile(String birthday, String firstName, String phone, String email, String providerUserId, String lastName, String provider, String avatar) {
        this.birthday = birthday;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.providerUserId = providerUserId;
        this.lastName = lastName;
        this.provider = provider;
        this.avatar = avatar;
    }

    public String getBirthday() {

        return birthday;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getProviderUserId() {

        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {

        this.providerUserId = providerUserId;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getProvider() {

        return provider;
    }

    public void setProvider(String provider) {

        this.provider = provider;
    }

    public String getAvatar() {

        return avatar;
    }

    public void setAvatar(String avatar) {

        this.avatar = avatar;
    }

    @Override
    public String toString() {

        return "SocialProfile{" +
                "birthday='" + birthday + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", providerUserId='" + providerUserId + '\'' +
                ", lastName='" + lastName + '\'' +
                ", provider='" + provider + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
