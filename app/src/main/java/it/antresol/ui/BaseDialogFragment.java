package it.antresol.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.antresol.R;

/**
 * Created by fastwow on 28.02.2015.
 */
public class BaseDialogFragment extends DialogFragment {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected View mRoot = null;
    protected IUIEventListener mUIEventListener = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.TransparentDialog);
    }

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
