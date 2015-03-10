package it.antresol.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 2/12/15.
 */
public class User extends BaseModel implements Parcelable {

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

    private User(Parcel in) {

        userId = in.readInt();
        avatar = in.readString();
        phone = in.readString();
        firstName = in.readString();
        lastName = in.readString();
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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {

        out.writeLong(userId);
        out.writeString(avatar);
        out.writeString(phone);
        out.writeString(firstName);
        out.writeString(lastName);
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {

        public User createFromParcel(Parcel in) {

            return new User(in);
        }

        public User[] newArray(int size) {

            return new User[size];
        }
    };
}
