package it.antresol.ui.users;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;
import it.antresol.api.AntresolAPIManager;
import it.antresol.model.User;
import it.antresol.ui.BaseFragment;
import it.antresol.ui.ads.AdAdapter;
import it.antresol.utils.BlurTransform;
import it.antresol.utils.GlobalArgs;

/**
 * Created by fastwow on 28.02.2015.
 */
public class UserProfileFragment extends BaseFragment {

    private static final String TAG = UserProfileFragment.class.getSimpleName();

    private static final int COLUMN_COUNT = 2;

    @InjectView(R.id.list)
    RecyclerView mAdListRecyclerView;
    private AdAdapter mAdAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    private User mUser;

    @InjectView(R.id.avatar)
    ImageView mAvatarImageView;

    @InjectView(R.id.name)
    TextView mNameTv;

    @InjectView(R.id.sale_counter)
    TextView mSaleCounterTv;

    @InjectView(R.id.buy_counter)
    TextView mBuyCounterTv;

    @InjectView(R.id.since_date)
    TextView mSinceDateTv;

    @InjectView(R.id.location)
    TextView mLocationTv;

    @InjectView(R.id.screen_bg)
    ImageView mScreenBgImageView;

    public static UserProfileFragment newInstance(long userId) {

        UserProfileFragment instance = new UserProfileFragment();

        Bundle args = new Bundle();
        args.putLong(GlobalArgs.USER_ID, userId);

        instance.setArguments(args);

        return instance;
    }

    private void initViews() {


        mLayoutManager = new StaggeredGridLayoutManager(COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        mAdListRecyclerView.setLayoutManager(mLayoutManager);
        mAdListRecyclerView.setItemAnimator(new DefaultItemAnimator());

        if (mUser != null) {

            mNameTv.setText(mUser.getFirstName() + " " + mUser.getLastName1Sym() + ".");

            mPicasso.load(mUser.getAvatar())
                    .error(android.R.drawable.stat_notify_error)
                    .placeholder(android.R.drawable.stat_notify_sync)
                    .into(mAvatarImageView);

            mPicasso.load(mUser.getAvatar())
//                    .error(android.R.drawable.stat_notify_error)
                    .placeholder(android.R.drawable.stat_notify_sync)
                    .transform(new BlurTransform(getApp()))
                    .into(mScreenBgImageView);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            Long userId = getArguments().getLong(GlobalArgs.USER_ID);
            mUser = AntresolAPIManager.getInstance().getUserFromCache(userId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_user_profile, container, false);

        ButterKnife.inject(this, mRootView);

        initViews();

        return mRootView;
    }
}
