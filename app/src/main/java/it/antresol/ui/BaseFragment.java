package it.antresol.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by artem on 2/16/15.
 */
public class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected View mRoot = null;
    protected IUIEventListener mUIEventListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {

            mUIEventListener = (IUIEventListener) activity;
        } catch (Throwable th) {

            Log.e(TAG, "failed ", th);
        }
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
}
