package it.antresol.ui.users;

import android.os.Bundle;
import android.view.MenuItem;

import it.antresol.R;
import it.antresol.ui.BaseActivityBarActivity;
import it.antresol.utils.GlobalArgs;

/**
 * Created by artem on 3/8/15.
 */
public class UserProfileActivity extends BaseActivityBarActivity {


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // as you specify a parent activity in AndroidManifest.xml.
        // automatically handle clicks on the Home/Up button, so long

        switch (item.getItemId()) {

            case android.R.id.home:

                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {

            if (getIntent() == null || getIntent().getExtras() == null) {

                finish();
                return;
            } else {

                long userId = getIntent().getExtras().getLong(GlobalArgs.USER_ID);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, UserProfileFragment.newInstance(userId)).commit();
            }
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
