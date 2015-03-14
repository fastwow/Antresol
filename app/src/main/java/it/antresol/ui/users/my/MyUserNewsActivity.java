package it.antresol.ui.users.my;

import android.os.Bundle;
import android.view.MenuItem;

import it.antresol.ui.BaseActivityBarActivity;

/**
 * Created by artem on 3/14/15.
 */
public class MyUserNewsActivity extends BaseActivityBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
