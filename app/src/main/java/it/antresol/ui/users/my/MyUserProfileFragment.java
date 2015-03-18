package it.antresol.ui.users.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import it.antresol.model.CurrentUser;
import it.antresol.ui.BaseFragment;
import it.antresol.ui.ads.AdAdapter;
import it.antresol.utils.PreferenceHelper;

/**
 * Created by artem on 3/14/15.
 */
public class MyUserProfileFragment extends BaseFragment {

    public static final String TAG = MyUserProfileFragment.class.getSimpleName();


    private static final int COLUMN_COUNT = 2;

    @InjectView(R.id.list)
    RecyclerView mAdListRecyclerView;
    private AdAdapter mAdAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    @InjectView(R.id.avatar)
    ImageView mAvatarImageView;

    @InjectView(R.id.name)
    TextView mNameTv;

    @InjectView(R.id.since_date)
    TextView mSinceDateTv;

    @InjectView(R.id.location)
    TextView mLocationTv;

    private CurrentUser mUser;

    public static Fragment newInstance() {

        MyUserProfileFragment instance = new MyUserProfileFragment();

        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getActionBar() != null) {

            getActionBar().setTitle(R.string.current_user);
        }
    }

    private void initViews() {

        mLayoutManager = new StaggeredGridLayoutManager(COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        mAdListRecyclerView.setLayoutManager(mLayoutManager);
        mAdListRecyclerView.setItemAnimator(new DefaultItemAnimator());

        if (getUser() != null) {

            mNameTv.setText(mUser.getUsername());

            mPicasso.load(mUser.getAvatar())
                    .error(android.R.drawable.stat_notify_error)
                    .placeholder(android.R.drawable.stat_notify_sync)
                    .into(mAvatarImageView);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_my_user_profile, container, false);

        ButterKnife.inject(this, mRootView);

        initViews();

        return mRootView;
    }

    private CurrentUser getUser() {

        if (mUser == null)
            mUser = PreferenceHelper.getInstance(getApp()).getCurrentUser();

        return mUser;
    }

}
