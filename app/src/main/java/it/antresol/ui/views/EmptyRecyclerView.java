package it.antresol.ui.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by artem on 3/19/15.
 */
public class EmptyRecyclerView extends RecyclerView {

    @Nullable
    View emptyView;

    private boolean isInProgress = false;

    public EmptyRecyclerView(Context context) {
        super(context);
    }

    public EmptyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    void checkIfEmpty() {

        if (emptyView != null) {

            if (!isInProgress) {

                emptyView.setVisibility(getAdapter() != null &&
                        getAdapter().getItemCount() > 0 ? GONE : VISIBLE);
            }
        }
    }

    public void setInProgress(boolean isInProgress) {

        this.isInProgress = isInProgress;
    }

    public boolean isInProgress() {

        return isInProgress;
    }

    final AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            checkIfEmpty();
        }
    };

    @Override
    public void setAdapter(@Nullable Adapter adapter) {
        final RecyclerView.Adapter oldAdapter = getAdapter();
        if (oldAdapter != null) {
            oldAdapter.unregisterAdapterDataObserver(observer);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(observer);
        }
    }

    public void setEmptyView(@Nullable View emptyView) {
        this.emptyView = emptyView;
        checkIfEmpty();
    }
}