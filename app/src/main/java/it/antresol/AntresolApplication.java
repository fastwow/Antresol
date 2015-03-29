package it.antresol;

import android.app.Application;

import it.antresol.api.AntresolAPIManager;
import it.antresol.utils.UserPreferenceHelper;

/**
 * Created by artem on 2/16/15.
 */
public class AntresolApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AntresolAPIManager.init(this);
        UserPreferenceHelper.init(this);
    }
}
