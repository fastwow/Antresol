package it.antresol.ui.ads;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;
import it.antresol.model.Ad;

/**
 * Created by artem on 2/19/15.
 */
public class AdAdapter extends RecyclerView.Adapter<AdAdapter.ViewHolder> {

    private static final String TAG = AdAdapter.class.getSimpleName();

    public Picasso mPicasso;

    private List<Ad> mAdList;

    public AdAdapter(Context context) {

        mPicasso = new Picasso.Builder(context.getApplicationContext())
                .indicatorsEnabled(true)
                .build();
        mAdList = new LinkedList<Ad>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_ad_list_item, parent, false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Ad item = mAdList.get(position);

        mPicasso.load(item.getImage() != null ? item.getImage().getUrl() : "")
                .error(android.R.drawable.stat_notify_error)
                .placeholder(android.R.drawable.stat_notify_sync).into(holder.mAdImageView);
        holder.mTitleTv.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {

        return mAdList != null ? mAdList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.image)
        ImageView mAdImageView;

        @InjectView(R.id.title)
        TextView mTitleTv;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.inject(this, itemView);
        }
    }

    public void addAll(List<Ad> adList) {

        Log.d(TAG, "getAdList.size4 = " + adList.size());

        mAdList.addAll(adList);
    }

    public void clear() {

        Log.d(TAG, "clear");

        mAdList.clear();
    }
}
