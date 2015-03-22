package it.antresol.ui.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;
import it.antresol.api.AntresolAPIManager;
import it.antresol.model.Ad;
import it.antresol.ui.BaseFragment;
import it.antresol.utils.GlobalArgs;

/**
 * Created by fastwow on 28.02.2015.
 */
public class AdPageFragment extends BaseFragment {

    private Ad mAd;

    @InjectView(R.id.avatar)
    ImageView mAvatarImageView;

    @InjectView(R.id.user_name)
    TextView mUserNameTv;

    @InjectView(R.id.title)
    TextView mAdTitleTv;

    @InjectView(R.id.desc)
    TextView mAdDescTv;

    @InjectView(R.id.price)
    TextView mPriceTv;

    @InjectView(R.id.want)
    View mWantView;

    @InjectView(R.id.scroll_container)
    ScrollView mContainerScrollView;

    @InjectView(R.id.image_pager)
    ViewPager mImagePager;

    private ImagePagerAdapter mAdapter;

    private View.OnClickListener mWantViewOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            //TODO MAKE OFFER
        }
    };

    public static AdPageFragment newInstance(long adId) {

        AdPageFragment instance = new AdPageFragment();

        Bundle args = new Bundle();
        args.putLong(GlobalArgs.AD_ID, adId);

        instance.setArguments(args);

        return instance;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            Long adId = getArguments().getLong(GlobalArgs.AD_ID);
            mAd = AntresolAPIManager.getInstance().getAdFromCache(adId);
        }
    }

    private void initViews() {

        if (mAd != null) {

            mPriceTv.setText(mAd.getPrice() + " " + getActivity().getString(R.string.currency_uah));
            mWantView.setOnClickListener(mWantViewOnClickListener);
            if (getActionBar() != null) {

                getActionBar().setTitle(mAd.getTitle());
            }

            mAdapter = new ImagePagerAdapter(getActivity(), mAd.getImageList());
            mImagePager.setAdapter(mAdapter);

            String userAvatarUrl = "";
            String userName = "";
            if (mAd.getUser() != null) {

                userAvatarUrl = mAd.getUser().getAvatar();
                userName = mAd.getUser().getFirstName() + " " + mAd.getUser().getLastName();
            }
            mPicasso.load(userAvatarUrl)
                    .error(android.R.drawable.stat_notify_error)
                    .placeholder(android.R.drawable.stat_notify_sync)
                    .into(mAvatarImageView);
            mUserNameTv.setText(userName);

            mAdTitleTv.setText(mAd.getTitle());
            mAdDescTv.setText(mAd.getDesc());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_ad_page, container, false);

        ButterKnife.inject(this, mRootView);

        initViews();

        return mRootView;
    }
}
