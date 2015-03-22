package it.antresol.ui.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;
import it.antresol.ui.BaseDialogFragment;

/**
 * Created by artem on 3/22/15.
 */
public class FullscreenImageDialogFragment extends BaseDialogFragment {

    public static final String TAG = FullscreenImageDialogFragment.class.getSimpleName();

    @InjectView(R.id.image)
    ImageView mImageView;

    private static final String IMAGE_URL = "image_url";

    public static DialogFragment newInstance(String adImageUrl) {

        DialogFragment instance = new FullscreenImageDialogFragment();

        Bundle args = new Bundle();
        args.putString(IMAGE_URL, adImageUrl);

        instance.setArguments(args);

        return instance;
    }

    private String getAdImageUrl() {

        return getArguments() != null ? getArguments().getString(IMAGE_URL, "") : "";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_dialog_fullscreen_image, container, false);

        ButterKnife.inject(this, mRootView);


        mPicasso.load(getAdImageUrl())
                .error(android.R.drawable.stat_notify_error)
                .placeholder(android.R.drawable.stat_notify_sync)
                .into(mImageView);

        return mRootView;
    }
}
