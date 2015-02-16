package antresol.it.antresol.ui.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import antresol.it.antresol.R;
import antresol.it.antresol.ui.BaseFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by artem on 2/16/15.
 */
public class AdListFragment extends BaseFragment {

    private static final String TAG = AdListFragment.class.getSimpleName();

    private static final int COLUMN_COUNT = 2;

    @InjectView(R.id.list)
    RecyclerView mPostListRecyclerView;

    StaggeredGridLayoutManager mLayoutManager;

    public static Fragment newInstance() {

        Fragment instance = new Fragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_ad_list, container, false);

        ButterKnife.inject(this, mRoot);

        mLayoutManager = new StaggeredGridLayoutManager(COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL);

        mPostListRecyclerView.setLayoutManager(mLayoutManager);
        mPostListRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.inject(this, mRoot);
    }
}