package it.antresol.ui.ads;

import android.os.Bundle;

import it.antresol.R;
import it.antresol.ui.BaseActivityBarActivity;
import it.antresol.ui.users.UserLoginFragment;

/**
 * Created by fastwow on 28.02.2015.
 */
public class AdPageActivity extends BaseActivityBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, AdPageFragment.newInstance())
                    .commit();
        }
    }
}
