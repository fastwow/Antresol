package it.antresol.ui.users;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import it.antresol.R;
import it.antresol.ui.BaseActivityBarActivity;
import it.antresol.ui.ads.AdListFragment;

/**
 * Created by fastwow on 28.02.2015.
 */
public class UserLoginActivity extends BaseActivityBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, UserLoginFragment.newInstance())
                    .commit();
        }
    }
}
