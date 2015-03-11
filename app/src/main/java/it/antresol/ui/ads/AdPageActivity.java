package it.antresol.ui.ads;

import android.os.Bundle;
import android.view.MenuItem;

import it.antresol.R;
import it.antresol.ui.BaseActivityBarActivity;
import it.antresol.utils.GlobalArgs;

/**
 * Created by fastwow on 28.02.2015.
 */
public class AdPageActivity extends BaseActivityBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {

            if (getIntent() == null || getIntent().getExtras() == null) {

                finish();
                return;
            } else {

                long adId = getIntent().getExtras().getLong(GlobalArgs.AD_ID);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, AdPageFragment.newInstance(adId))
                        .commit();
            }
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
