package it.antresol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 2/12/15.
 */
public class User extends BaseModel {

    @SerializedName("user_id")
    @Expose
    private long userId;

    @Expose
    private String avatar;

    @Expose
    private String phone;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    public User() {

    }

    public User(long userId, String avatar, String phone, String lastName, String firstName) {

        this.userId = userId;
        this.avatar = avatar;
        this.phone = phone;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    public String getAvatar() {

        return avatar;
    }

    public void setAvatar(String avatar) {

        this.avatar = avatar;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public char getLastName1Sym() {

        return lastName.charAt(0);
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }
}
