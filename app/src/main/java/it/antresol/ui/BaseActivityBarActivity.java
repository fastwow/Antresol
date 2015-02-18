package it.antresol.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;

/**
 * Created by artem on 2/16/15.
 */
public class BaseActivityBarActivity extends ActionBarActivity implements IUIEventListener {

    @InjectView(R.id.progress_bar)
    private ProgressBar mWaitingProgressBar;
    @InjectView(R.id.error_message)
    private TextView mErrorMessageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
    }

    private void setErrorMessageVisibility(boolean isVisible) {

        if (mErrorMessageTv != null)
            mErrorMessageTv.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showErrorMessage(String text) {

        if (mErrorMessageTv != null) {

            String textToSet = !TextUtils.isEmpty(text) ? text : getString(R.string.error_message_default);
            mErrorMessageTv.setText(textToSet);
        }
        setErrorMessageVisibility(true);
    }

    @Override
    public void showErrorMessage() {

        showErrorMessage("");
    }

    @Override
    public void hideErrorMessage() {

        setErrorMessageVisibility(false);
    }

    private void setWaitingProgressBarVisibility(boolean isVisible) {

        if (mWaitingProgressBar != null)
            mWaitingProgressBar.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showProgressBar() {

        setProgressBarVisibility(false);
    }

    @Override
    public void dismissProgressBar() {

        setProgressBarVisibility(false);
    }
}
