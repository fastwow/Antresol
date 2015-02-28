package it.antresol.ui.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import it.antresol.R;
import it.antresol.ui.BaseFragment;

/**
 * Created by fastwow on 28.02.2015.
 */
public class AdPageFragment extends BaseFragment {

    public static AdPageFragment newInstance() {

        AdPageFragment instance = new AdPageFragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_ad_page, container, false);

        ButterKnife.inject(this, mRoot);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
