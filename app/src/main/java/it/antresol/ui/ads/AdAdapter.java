package it.antresol.ui.ads;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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
import it.antresol.model.User;
import it.antresol.ui.views.RoundedTransformation;

/**
 * Created by artem on 2/19/15.
 */
public class AdAdapter extends RecyclerView.Adapter<AdAdapter.ViewHolder> {

    private static final String TAG = AdAdapter.class.getSimpleName();

    public Picasso mPicasso;
    private List<Ad> mAdList;
    private Context mContext;
    private View.OnClickListener mItemOnClickListener = null;

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    public AdAdapter(Context context, View.OnClickListener itemOnClickListener) {

        mPicasso = new Picasso.Builder(context.getApplicationContext())
                .indicatorsEnabled(false)
                .build();
        mAdList = new LinkedList<Ad>();
        mContext = context;
        mItemOnClickListener = itemOnClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_ad_list_item, parent, false);

        itemView.setOnClickListener(mItemOnClickListener);
        itemView.findViewById(R.id.avatar_content).setOnClickListener(mItemOnClickListener);
        itemView.findViewById(R.id.more).setOnClickListener(mItemOnClickListener);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Ad item = mAdList.get(position);
        User user = item.getUser();

        mPicasso.load(item.getImage() != null ? item.getImage().getUrl() : "")
                .error(android.R.drawable.stat_notify_error)
                .placeholder(android.R.drawable.stat_notify_sync).into(holder.mAdImageView);

        holder.mTitleTv.setText(item.getTitle());

        holder.mPriceTv.setText(item.getPrice() + " " + mContext.getString(R.string.currency_uah));

        mPicasso.load(user != null ? user.getAvatar() : "")
                .error(android.R.drawable.stat_notify_error)
                .placeholder(android.R.drawable.stat_notify_sync)
                .transform(new RoundedTransformation())
                .into(holder.mAvatarImageVIew);

        holder.mFirstNameTv.setText(user.getFirstName() + " " + user.getLastName1Sym() + ".");
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

        @InjectView(R.id.price)
        TextView mPriceTv;

        @InjectView(R.id.avatar)
        ImageView mAvatarImageVIew;

        @InjectView(R.id.name)
        TextView mFirstNameTv;

        @InjectView(R.id.more)
        View mMoreView;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.inject(this, itemView);
        }
    }

    public void addAll(List<Ad> adList) {

        mAdList.addAll(adList);
    }

    public Ad getItem(int pos) {

        return mAdList.get(pos);
    }

    public void clear() {

        mAdList.clear();
    }
}
