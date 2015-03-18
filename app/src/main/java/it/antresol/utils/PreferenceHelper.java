package it.antresol.utils;

import android.content.Context;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import it.antresol.model.CurrentUser;

/**
 * Created by artem on 2/16/15.
 */
public class PreferenceHelper {

    private static PreferenceHelper mInstance = null;

    private Context mContenxt;

    // Fields name
    private static final String CURRENT_USER = "currentUser";

    // reflection fields
    private boolean isUserLogged;

    private CurrentUser currentUser;

    private PreferenceHelper(Context context) {

        mContenxt = context;
        String userJson = getField(CURRENT_USER);
        isUserLogged = userJson != null;
        currentUser = toCurrentUser(userJson);
    }

    public static PreferenceHelper getInstance(Context context) {

        if (mInstance == null)
            mInstance = new PreferenceHelper(context);

        return mInstance;
    }

    private void saveField(String key, boolean value) {

        PreferenceManager.getDefaultSharedPreferences(mContenxt).edit().putBoolean(key, value).commit();
    }

    private void saveField(String key, String value) {

        PreferenceManager.getDefaultSharedPreferences(mContenxt).edit().putString(key, value).commit();
    }

    private String getField(String key) {

        return PreferenceManager.getDefaultSharedPreferences(mContenxt).getString(key, null);
    }

    private CurrentUser toCurrentUser(String userJson) {

        return userJson != null ? new Gson().fromJson(userJson, CurrentUser.class) : null;
    }

    public CurrentUser getCurrentUser() {

        return currentUser != null ? currentUser : toCurrentUser(getField(CURRENT_USER));
    }

    public void setCurrentUser(CurrentUser user) {

        saveField(CURRENT_USER, new Gson().toJson(user));
        isUserLogged = user != null;
        currentUser = user;
    }

    public boolean isUserLogged() {

        return isUserLogged;
    }
}