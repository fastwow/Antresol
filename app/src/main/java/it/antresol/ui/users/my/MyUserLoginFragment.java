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
 * Created by fastwow on 28.02.2015.
 */
public class MyUserLoginFragment extends BaseFragment {


    public static final String TAG = MyUserLoginFragment.class.getSimpleName();


    public static Fragment newInstance() {

        MyUserLoginFragment instance = new MyUserLoginFragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_my_user_login, container, false);

        ButterKnife.inject(this, mRootView);

        return mRootView;
    }
}
