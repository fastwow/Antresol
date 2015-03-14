package it.antresol.ui.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @InjectView(R.id.price)
    TextView mPriceTv;

    @InjectView(R.id.want)
    View mWantView;

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
