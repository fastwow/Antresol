package it.antresol.ui.views;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by artem on 2/19/15.
 */
public abstract class EndlessRecyclerOnScrollListener extends
        RecyclerView.OnScrollListener {

    public static String TAG = EndlessRecyclerOnScrollListener.class
            .getSimpleName();

    private int previousTotal = 0;
    protected boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;

    private int current_page = 1;

    private StaggeredGridLayoutManager mLayoutManager;

    public EndlessRecyclerOnScrollListener(StaggeredGridLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;

    }

    private int getMin(int into[]) {

        int min = Integer.MAX_VALUE;
        if (into != null) {

            for (int item : into) {

                if (min > item)
                    min = item;
            }
        }

        return min != Integer.MAX_VALUE ? min : RecyclerView.NO_POSITION;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLayoutManager.getItemCount();
        firstVisibleItem = getMin(mLayoutManager.findFirstVisibleItemPositions(null));
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading
                && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            // End has been reached

            // Do something
            current_page++;

            onLoadMore(current_page);

            loading = true;
        }
    }

    public void setLoading(boolean loading) {

        this.loading = loading;
    }

    public abstract void onLoadMore(int currentPage);
}