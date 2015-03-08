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
 * Created by artem on 3/7/15.
 */
public class CreateAdFragment extends BaseFragment {

    private static final String TAG = CreateAdFragment.class.getSimpleName();

    public static CreateAdFragment newInstance() {

        CreateAdFragment instance = new CreateAdFragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        mRoot = inflater.inflate(R.layout.fragment_create_ad, container, false);

        ButterKnife.inject(this, mRoot);

        return mRoot;
    }
}
