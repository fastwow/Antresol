package it.antresol.utils;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by artem on 2/16/15.
 */
public class PreferenceHelper {

    private static PreferenceHelper mInstance = null;

    private Context mContenxt;

    // Fields name
    private static final String IS_USER_LOGGED = "isUserLogged";

    // reflection fields
    private boolean isUserLogged;

    private PreferenceHelper(Context context) {

        mContenxt = context;
    }

    public static PreferenceHelper getInstance(Context context) {

        if (mInstance == null)
            mInstance = new PreferenceHelper(context);

        return mInstance;
    }

    private void saveField(String key, boolean value) {

        PreferenceManager.getDefaultSharedPreferences(mContenxt).edit().putBoolean(key, value).commit();
    }

    public void setUserLogged(boolean isUserLogged) {

        saveField(IS_USER_LOGGED, isUserLogged);
        this.isUserLogged = isUserLogged;
    }

    public boolean isUserLogged() {

        return isUserLogged;
    }
}