package it.antresol.utils;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;

import it.antresol.model.CurrentUser;
import it.antresol.model.Like;

/**
 * Created by artem on 2/16/15.
 */
public class UserPreferenceHelper {

    public static final String TAG = UserPreferenceHelper.class.getSimpleName();

    private static UserPreferenceHelper mInstance = null;

    private Context mContenxt;

    // Fields name
    private static final String CURRENT_USER = "currentUser";

    // reflection fields
    private boolean isUserLogged;

    private CurrentUser currentUser;

    private UserPreferenceHelper(Context context) {

        mContenxt = context;
        String userJson = getField(CURRENT_USER);
        isUserLogged = userJson != null;
        currentUser = toCurrentUser(userJson);
    }

    public static void init(Context context) {

        mInstance = new UserPreferenceHelper(context);
    }

    public static UserPreferenceHelper getInstance() {

        return mInstance;
    }

    private void saveField(String key, boolean value) {

        PreferenceManager.getDefaultSharedPreferences(mContenxt).edit().putBoolean(key, value).commit();
    }

    private void saveField(String key, CurrentUser value) {

        PreferenceManager.getDefaultSharedPreferences(mContenxt).edit().putString(key, new Gson().toJson(value)).commit();
    }

    private void saveField(String key, String value) {

        PreferenceManager.getDefaultSharedPreferences(mContenxt).edit().putString(key, value).commit();
    }

    private String getField(String key) {

        return PreferenceManager.getDefaultSharedPreferences(mContenxt).getString(key, null);
    }

    private CurrentUser createUser() {

        setCurrentUser(new CurrentUser());

        return currentUser;
    }

    private CurrentUser toCurrentUser(String userJson) {

        return userJson != null ? new Gson().fromJson(userJson, CurrentUser.class) : createUser();
    }

    public CurrentUser getCurrentUser() {

        return currentUser != null ? currentUser : toCurrentUser(getField(CURRENT_USER));
    }

    public String getAccessToken() {

        return getCurrentUser().getAccessToken();
    }

    public void setCurrentUser(CurrentUser user) {

        saveField(CURRENT_USER, user);
        isUserLogged = user != null;
        currentUser = user;
    }

    private void saveChanges() {

        saveField(CURRENT_USER, currentUser);
    }

    public void addLike(Like like) {

        try {

            getCurrentUser().getLikeList().add(like);
            saveChanges();
        } catch (Exception e) {

            Log.e(TAG, "Failed !", e);
        }
    }

    public void deleteLike(Like like) {

        try {

            getCurrentUser().getLikeList().remove(like);
            saveChanges();
        } catch (Exception e) {

            Log.e(TAG, "Failed !", e);
        }
    }


    public boolean isAdLiked(long adId) {

        boolean res = false;
        Like likedAd = null;
        try {

            likedAd = new Like(adId, getCurrentUser().getUserId());
            res = getCurrentUser().getLikeList().contains(likedAd);
        } catch (Exception ex) {

            Log.e(TAG, "failed ! ", ex);
        } finally {


        }

        return res;
    }

    public boolean isUserLogged() {

        return getAccessToken() != null;
    }
}