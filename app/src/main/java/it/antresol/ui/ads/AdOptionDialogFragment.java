package it.antresol.ui.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;
import it.antresol.ui.BaseDialogFragment;
import it.antresol.utils.GlobalArgs;
import it.antresol.utils.UserPreferenceHelper;

/**
 * Created by fastwow on 25.02.2015.
 */
public class AdOptionDialogFragment extends BaseDialogFragment {

    public static final String TAG = AdOptionDialogFragment.class.getSimpleName();

    @InjectView(R.id.close)
    ImageView mCloseImageView;

    @InjectView(R.id.send_msg)
    ImageView mSendMsgImageView;

    @InjectView(R.id.like)
    ImageView mLikeImageView;

    @InjectView(R.id.make_call)
    ImageView mMakeCallImageView;

    private long mAdId = -1;

    public static AdOptionDialogFragment newInstance(long adId) {

        Bundle args = new Bundle();
        args.putLong(GlobalArgs.AD_ID, adId);

        AdOptionDialogFragment instance = new AdOptionDialogFragment();
        instance.setArguments(args);

        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            mAdId = getArguments().getLong(GlobalArgs.AD_ID);
        }
    }

    private void initViews() {

        mLikeImageView.setSelected(UserPreferenceHelper.getInstance().isAdLiked(mAdId));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_ad_user_option, container, false);

        ButterKnife.inject(this, mRootView);

        mCloseImageView.setOnClickListener(mOptionButtonsOnClickListener);
        mSendMsgImageView.setOnClickListener(mOptionButtonsOnClickListener);
        mLikeImageView.setOnClickListener(mOptionButtonsOnClickListener);
        mMakeCallImageView.setOnClickListener(mOptionButtonsOnClickListener);

        initViews();

        return mRootView;
    }

    private View.OnClickListener mOptionButtonsOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.close:

                    dismiss();
                    break;
                case R.id.send_msg:

                    break;
                case R.id.like:

                    v.setSelected(!v.isSelected());
                    break;

                case R.id.make_call:

                    break;
            }
        }
    };
}
