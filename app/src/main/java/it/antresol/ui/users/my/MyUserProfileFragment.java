package it.antresol.ui.users.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import it.antresol.R;
import it.antresol.ui.BaseFragment;

/**
 * Created by artem on 3/14/15.
 */
public class MyUserProfileFragment extends BaseFragment {

    public static final String TAG = MyUserProfileFragment.class.getSimpleName();

    public static Fragment newInstance() {

        MyUserProfileFragment instance = new MyUserProfileFragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_my_user_profile, container, false);

        ButterKnife.inject(this, mRootView);

        return mRootView;
    }
}
