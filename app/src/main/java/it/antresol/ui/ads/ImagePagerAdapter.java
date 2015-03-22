package it.antresol.ui.ads;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

    private Picasso mPicasso;

    public ImagePagerAdapter(Context context, List<Image> list) {

        mPicasso = new Picasso.Builder(context.getApplicationContext())
                .indicatorsEnabled(false)
                .build();

        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mImageList = list;

        if (mImageList == null)
            mImageList = new LinkedList<>();
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

        View itemView = mLayoutInflater.inflate(R.layout.layout_image_pager_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image);

        Image imageObject = mImageList.get(position);

        mPicasso.load(imageObject.getUrl() != null ? imageObject.getUrl() : "")
                .error(android.R.drawable.stat_notify_error)
                .placeholder(android.R.drawable.stat_notify_sync).into(imageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((FrameLayout) object);
    }
}
