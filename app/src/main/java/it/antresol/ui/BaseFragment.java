package it.antresol.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

/**
 * Created by artem on 2/16/15.
 */
public class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected View mRootView = null;
    protected IUIEventListener mUIEventListener = null;

    private ActionBar mActionBar;

    protected Picasso mPicasso;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {

            if (getActivity() instanceof IUIEventListener)
                mUIEventListener = (IUIEventListener) activity;

            if (getActivity() instanceof ActionBarActivity)
                mActionBar = ((ActionBarActivity) activity).getSupportActionBar();
        } catch (Throwable th) {

            Log.e(TAG, "failed ", th);
        }

        mPicasso = new Picasso.Builder(activity.getApplicationContext())
                .indicatorsEnabled(false)
                .build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mUIEventListener = null;
    }

    public ActionBar getActionBar() {

        return mActionBar;
    }
}
