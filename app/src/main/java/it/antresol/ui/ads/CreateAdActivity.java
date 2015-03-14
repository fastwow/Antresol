package it.antresol.ui.ads;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import it.antresol.R;
import it.antresol.ui.BaseActivityBarActivity;

/**
 * Created by artem on 3/8/15.
 */
public class CreateAdActivity extends BaseActivityBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, CreateAdFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_ad, menu);
        return true;
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