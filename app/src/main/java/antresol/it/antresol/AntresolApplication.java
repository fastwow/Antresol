package antresol.it.antresol;

import android.app.Application;

import antresol.it.antresol.api.AntresolAPIManager;

/**
 * Created by artem on 2/16/15.
 */
public class AntresolApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AntresolAPIManager.init(this);
    }
}
