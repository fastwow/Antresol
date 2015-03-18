package it.antresol.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import it.antresol.R;

/**
 * Created by artem on 3/14/15.
 */
public class SplashScreenActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_container);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SplashScreenFragment.newInstance())
                    .commit();
        }
    }
}
