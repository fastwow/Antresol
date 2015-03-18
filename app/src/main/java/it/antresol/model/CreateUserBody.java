package it.antresol.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 3/18/15.
 */
public class CreateUserBody extends BaseModel {

    public static final String PROVIDER_FACEBOOK = "facebook";
    public static final String PROVIDER_VKONTAKTE =  "vkontakte";

    @SerializedName("last_name")
    private String lastName;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("provider")
    private String provider;
    @SerializedName("provider_user_id")
    private String providerUserId;
    @SerializedName("token")
    private String token;

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

    public String getProvider() {

        return provider;
    }

    public void setProvider(String provider) {

        this.provider = provider;
    }

    public String getProviderUserId() {

        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {

        this.providerUserId = providerUserId;
    }

    public CreateUserBody() {

    }

    public CreateUserBody(String lastName, String firstName, String provider, String providerUserId, String token) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.provider = provider;
        this.providerUserId = providerUserId;
        this.token = token;
    }
}
