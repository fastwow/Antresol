package antresol.it.antresol.ui.ads;

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

import antresol.it.antresol.R;
import antresol.it.antresol.ui.BaseFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by artem on 2/16/15.
 */
public class AdListFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = AdListFragment.class.getSimpleName();

    private static final int LOADER_AD_LIST_ID = 100;

    private static final int COLUMN_COUNT = 2;

    @InjectView(R.id.list)
    private RecyclerView mAdListRecyclerView;
    private AdCursorAdapter mAdCursorAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    public static Fragment newInstance() {

        Fragment instance = new Fragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_ad_list, container, false);

        ButterKnife.inject(this, mRoot);

        mLayoutManager = new StaggeredGridLayoutManager(COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL);

        mAdListRecyclerView.setLayoutManager(mLayoutManager);
        mAdListRecyclerView.setItemAnimator(new DefaultItemAnimator());

        getLoaderManager().initLoader(LOADER_AD_LIST_ID, null, this);

        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ButterKnife.inject(this, mRoot);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        return null;
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {


    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        mAdCursorAdapter.swapCursor(data);
    }
}