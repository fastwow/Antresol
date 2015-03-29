package it.antresol.ui.users.my;

import android.os.Bundle;
import android.view.MenuItem;

import it.antresol.R;
import it.antresol.ui.BaseActivityBarActivity;
import it.antresol.utils.UserPreferenceHelper;

/**
 * Created by artem on 3/14/15.
 */
public class MyUserActivity extends BaseActivityBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {

            if (UserPreferenceHelper.getInstance().isUserLogged()) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, MyUserProfileFragment.newInstance())
                        .commit();
            } else {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, MyUserLoginFragment.newInstance())
                        .commit();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {

            case android.R.id.home:

                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
