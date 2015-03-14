package it.antresol.ui;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;

/**
 * Created by artem on 3/12/15.
 */
public class SplashScreenFragment extends BaseFragment {

    public static final String TAG = SplashScreenFragment.class.getSimpleName();

    private static final long DELAY_MS = 3000;
    private static final long DEBUG_DELAY_MS = 1500;

    @InjectView(R.id.antresol_image)
    ImageView mAntresolImageView;

    public static SplashScreenFragment newInstance() {

        SplashScreenFragment instance = new SplashScreenFragment();

        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_splashscreen, container, false);

        ButterKnife.inject(this, mRootView);


        mPicasso.load(R.drawable.splashscreen)
//                .error(android.R.drawable.stat_notify_error)
//                .placeholder(android.R.drawable.stat_notify_sync)
                .into(mAntresolImageView);

        return mRootView;
    }

    private boolean isDebuggable() {

        return (0 != (getActivity().getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE));
    }

    private long getDelayMs() {

        return isDebuggable() ? DEBUG_DELAY_MS : DELAY_MS;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRootView.postDelayed(new Runnable() {

            @Override
            public void run() {

                if (getActivity() != null) {

                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();
                }
            }
        }, getDelayMs());
    }

}