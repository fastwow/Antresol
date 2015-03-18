package it.antresol.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 3/18/15.
 */
public class CreateUserResponse {

    @SerializedName("data")
    @Expose
    private CurrentUser currentUser;

    public CreateUserResponse() {

    }

    public CreateUserResponse(CurrentUser currentUser) {

        this.currentUser = currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {

        this.currentUser = currentUser;
    }

    public CurrentUser getCurrentUser() {

        return currentUser;
    }
}
