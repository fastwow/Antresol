package it.antresol.ui.ads;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
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
import it.antresol.model.database.AntresolContentProvider;
import it.antresol.ui.BaseFragment;

/**
 * Created by artem on 2/16/15.
 */
public class AdListCursorFragment extends BaseFragment {/* implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = AdListCursorFragment.class.getSimpleName();

    private static final int LOADER_AD_LIST_ID = 100;

    private static final int COLUMN_COUNT = 2;

    @InjectView(R.id.list)
    RecyclerView mAdListRecyclerView;
    private AdCursorAdapter mAdCursorAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    public static Fragment newInstance() {

        AdListCursorFragment instance = new AdListCursorFragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_ad_list, container, false);

        ButterKnife.inject(this, mRoot);

        mLayoutManager = new StaggeredGridLayoutManager(COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL);

        mAdListRecyclerView.setLayoutManager(mLayoutManager);
        mAdListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdCursorAdapter = new AdCursorAdapter(getActivity(), null, 0);
        mAdListRecyclerView.setAdapter(mAdCursorAdapter);

        if (mUIEventListener != null)
            mUIEventListener.showProgressBar();
        getLoaderManager().initLoader(LOADER_AD_LIST_ID, null, this);

        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private boolean isNeedToFetchData(Cursor cursor) {

        return cursor == null || cursor.getCount() <= 0;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        switch (id) {

            case LOADER_AD_LIST_ID:

                return new CursorLoader(getActivity(),
                        AntresolContentProvider.ADS_CONTENT_URI, null, null, null, null);
            default:
                return null;
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mAdCursorAdapter.swapCursor(null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

//        mAdCursorAdapter.swapCursor(data);

//        if (isNeedToFetchData(data)) {

//            AntresolAPIManager.getInstance().getAdList(tru(IRequestStatusListener) getActivity());
        } else {

            if (mUIEventListener != null)
                mUIEventListener.dismissProgressBar();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.inject(this, mRoot);
    }
    */
}