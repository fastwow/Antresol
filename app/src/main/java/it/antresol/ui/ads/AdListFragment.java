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

import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ScrollDirectionListener;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;
import it.antresol.api.AntresolAPIManager;
import it.antresol.api.IRequestStatusListener;
import it.antresol.model.Ad;
import it.antresol.ui.BaseFragment;
import it.antresol.ui.views.EndlessRecyclerOnScrollListener;

/**
 * Created by artem on 2/19/15.
 */
public class AdListFragment extends BaseFragment implements IRequestStatusListener<List<Ad>> {

    private static final String TAG = AdListFragment.class.getSimpleName();

    private static final int COLUMN_COUNT = 2;

    @InjectView(R.id.list)
    RecyclerView mAdListRecyclerView;
    private AdAdapter mAdAdapter;
    private StaggeredGridLayoutManager mLayoutManager;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @InjectView(R.id.add_fab)
    FloatingActionButton mAddFloatingActionButton;

    private EndlessRecyclerOnScrollListener mOnScrollListener;

    private ScrollDirectionListener mScrollDirectionListener = new ScrollDirectionListener() {
        @Override
        public void onScrollDown() {

            // empty
        }

        @Override
        public void onScrollUp() {

            // empty
        }
    };

    public static Fragment newInstance() {

        AdListFragment instance = new AdListFragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_ad_list, container, false);

        ButterKnife.inject(this, mRoot);

        mLayoutManager = new StaggeredGridLayoutManager(COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        mOnScrollListener = new EndlessRecyclerOnScrollListener(mLayoutManager) {

            @Override
            public void onLoadMore(int currentPage) {

                AntresolAPIManager.getInstance().getAdList(AdListFragment.this, false);
            }
        };
        mAdListRecyclerView.setLayoutManager(mLayoutManager);
        mAdListRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdListRecyclerView.setOnScrollListener(mOnScrollListener);
//        mAddFloatingActionButton.attachToRecyclerView(mAdListRecyclerView, mScrollDirectionListener, mOnScrollListener);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

                AntresolAPIManager.getInstance().getAdList(AdListFragment.this, true);
            }
        });
        mAdAdapter = new AdAdapter(getActivity());
        mAdListRecyclerView.setAdapter(mAdAdapter);

        if (mUIEventListener != null)
            mUIEventListener.showProgressBar();
        AntresolAPIManager.getInstance().getAdList(this, true);

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
    public void onSuccess(List<Ad> result, boolean isNeedToRefreshData) {

        if (isNeedToRefreshData)
            mAdAdapter.clear();

        if (result != null)
            mAdAdapter.addAll(result);
        mAdAdapter.notifyDataSetChanged();

        if (mUIEventListener != null)
            mUIEventListener.dismissProgressBar();

        if (mSwipeRefreshLayout.isRefreshing())
            mSwipeRefreshLayout.setRefreshing(false);

        if (isNeedToRefreshData)
            mOnScrollListener.resetLoading();
    }

    @Override
    public void onError() {

        if (mSwipeRefreshLayout.isRefreshing())
            mSwipeRefreshLayout.setRefreshing(false);

        mOnScrollListener.resetLoading();

        if (mUIEventListener != null)
            mUIEventListener.showErrorMessage();
    }

    @Override
    public void onError(String text) {

        if (mSwipeRefreshLayout.isRefreshing())
            mSwipeRefreshLayout.setRefreshing(false);

        mOnScrollListener.resetLoading();

        if (mUIEventListener != null)
            mUIEventListener.showErrorMessage(text);
    }
}