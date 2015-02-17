package it.antresol.ui.ads;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import it.antresol.R;
import it.antresol.model.database.tables.ITable;
import it.antresol.ui.views.CursorAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by artem on 2/16/15.
 */
public class AdCursorAdapter extends CursorAdapter<AdCursorAdapter.ViewHolder> {

    /**
     * Recommended constructor.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     * @param flags   Flags used to determine the behavior of the adapter;
     *                Currently it accept {@link #FLAG_REGISTER_CONTENT_OBSERVER}.
     */
    public AdCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);


    }


    @Override
    protected void onContentChanged() {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.image)
        public ImageView mAdImageView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, itemView);

        }
    }

    @Override
    public AdCursorAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_ad_list_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(itemView);

        return vh;
    }

    @Override
    public void onBindViewHolder(AdCursorAdapter.ViewHolder holder, Cursor cursor) {

        // fill the holder

        String adImageUrl = cursor.getString(cursor.getColumnIndex(ITable.URL));

        mPicasso.load(adImageUrl).error(android.R.drawable.stat_notify_error).placeholder(android.R.drawable.stat_notify_sync).into(holder.mAdImageView);
    }
}
