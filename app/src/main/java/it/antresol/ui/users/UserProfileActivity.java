package it.antresol.ui.users;

import android.os.Bundle;

import it.antresol.R;
import it.antresol.ui.BaseActivityBarActivity;

/**
 * Created by artem on 3/8/15.
 */
public class UserProfileActivity extends BaseActivityBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, UserProfileFragment.newInstance())
                    .commit();
        }
    }
}
