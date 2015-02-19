package it.antresol.ui.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import it.antresol.api.IRequestStatusListener;
import it.antresol.model.GetAds;
import it.antresol.ui.BaseFragment;

/**
 * Created by artem on 2/19/15.
 */
public class AdListFragment extends BaseFragment implements IRequestStatusListener<GetAds> {

    private static final String TAG = AdListFragment.class.getSimpleName();

    private static final int COLUMN_COUNT = 2;

    @InjectView(R.id.list)
    RecyclerView mAdListRecyclerView;
    private AdAdapter mAdAdapter;
    private StaggeredGridLayoutManager mLayoutManager;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    public static Fragment newInstance() {

        AdListFragment instance = new AdListFragment();

        return instance;
    }

    private void refreshItems() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_ad_list, container, false);

        ButterKnife.inject(this, mRoot);

        mLayoutManager = new StaggeredGridLayoutManager(COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL);

        mAdListRecyclerView.setLayoutManager(mLayoutManager);
        mAdListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

                AntresolAPIManager.getInstance().getAdList(true, AdListFragment.this);
            }
        });
        mAdAdapter = new AdAdapter(getActivity());
        mAdListRecyclerView.setAdapter(mAdAdapter);

        if (mUIEventListener != null)
            mUIEventListener.showProgressBar();
        AntresolAPIManager.getInstance().getAdList(true, this);

        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.inject(this, mRoot);
    }

    @Override
    public void startFetchDataFromServer() {

        if (mUIEventListener != null)
            mUIEventListener.showProgressBar();
    }

    @Override
    public void onSuccess(GetAds result) {

        if (mUIEventListener != null)
            mUIEventListener.dismissProgressBar();
        if (mSwipeRefreshLayout.isRefreshing())
            mSwipeRefreshLayout.setRefreshing(false);
        if (result != null) {

            mAdAdapter.updateAdList(result.getData());
            mAdAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError() {

        if (mSwipeRefreshLayout.isRefreshing())
            mSwipeRefreshLayout.setRefreshing(false);
        if (mUIEventListener != null)
            mUIEventListener.showErrorMessage();
    }

    @Override
    public void onError(String text) {

        if (mSwipeRefreshLayout.isRefreshing())
            mSwipeRefreshLayout.setRefreshing(false);
        if (mUIEventListener != null)
            mUIEventListener.showErrorMessage(text);
    }
}