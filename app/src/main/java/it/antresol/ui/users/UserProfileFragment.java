package it.antresol.ui.users;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;
import it.antresol.api.AntresolAPIManager;
import it.antresol.ui.BaseFragment;
import it.antresol.ui.ads.AdAdapter;
import it.antresol.ui.views.EndlessRecyclerOnScrollListener;

/**
 * Created by fastwow on 28.02.2015.
 */
public class UserProfileFragment extends BaseFragment {

    private static final String TAG = UserProfileFragment.class.getSimpleName();

    private static final int COLUMN_COUNT = 2;

    @InjectView(R.id.list)
    RecyclerView mAdListRecyclerView;
    private AdAdapter mAdAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    public static UserProfileFragment newInstance() {

        UserProfileFragment instance = new UserProfileFragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_user_profile, container, false);

        ButterKnife.inject(this, mRoot);

        mLayoutManager = new StaggeredGridLayoutManager(COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        mAdListRecyclerView.setLayoutManager(mLayoutManager);
        mAdListRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return mRoot;
    }
}
