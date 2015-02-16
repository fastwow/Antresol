package antresol.it.antresol.model;

/**
 * Created by artem on 2/12/15.
 */
public class User extends BaseModel {

    private long userId;
    private String avatar;
    private String lastName;
    private String firstName;

    public User(long userId, String avatar, String firstName, String lastName) {

        this.userId = userId;
        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getAvatar() {

        return avatar;
    }

    public void setAvatar(String avatar) {

        this.avatar = avatar;
    }
}
