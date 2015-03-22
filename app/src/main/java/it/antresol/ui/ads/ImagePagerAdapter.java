package it.antresol.ui.ads;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

import it.antresol.R;
import it.antresol.model.Image;

/**
 * Created by artem on 3/22/15.
 */
public class ImagePagerAdapter extends PagerAdapter {

    private List<Image> mImageList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private View.OnClickListener mAdImageOnClickListener = null;
    private Picasso mPicasso;

    public ImagePagerAdapter(Context context, View.OnClickListener onClickListener, List<Image> list) {

        mPicasso = new Picasso.Builder(context.getApplicationContext())
                .indicatorsEnabled(false)
                .build();

        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mImageList = list;

        if (mImageList == null)
            mImageList = new LinkedList<>();

        mAdImageOnClickListener = onClickListener;
    }

    @Override
    public int getCount() {

        return mImageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == ((FrameLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Image imageObject = mImageList.get(position);

        View itemView = mLayoutInflater.inflate(R.layout.layout_image_pager_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image);

        String url = imageObject.getUrl() != null ? imageObject.getUrl() : "";
        mPicasso.load(url)
                .error(android.R.drawable.stat_notify_error)
                .placeholder(android.R.drawable.stat_notify_sync).into(imageView);

        imageView.setTag(url);
        imageView.setOnClickListener(mAdImageOnClickListener);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((FrameLayout) object);
    }
}
