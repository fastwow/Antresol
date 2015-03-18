package it.antresol.ui.users.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;
import it.antresol.ui.BaseFragment;
import it.antresol.ui.ads.AdAdapter;

/**
 * Created by artem on 3/14/15.
 */
public class MyUserProfileFragment extends BaseFragment {

    public static final String TAG = MyUserProfileFragment.class.getSimpleName();


    private static final int COLUMN_COUNT = 2;

    @InjectView(R.id.list)
    RecyclerView mAdListRecyclerView;
    private AdAdapter mAdAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    public static Fragment newInstance() {

        MyUserProfileFragment instance = new MyUserProfileFragment();

        return instance;
    }

    private void initViews() {

        mLayoutManager = new StaggeredGridLayoutManager(COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        mAdListRecyclerView.setLayoutManager(mLayoutManager);
        mAdListRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_my_user_profile, container, false);

        ButterKnife.inject(this, mRootView);

        initViews();

        return mRootView;
    }
}
