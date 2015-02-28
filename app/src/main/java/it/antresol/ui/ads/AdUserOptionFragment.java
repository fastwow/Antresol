package it.antresol.ui.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;
import it.antresol.ui.BaseDialogFragment;
import it.antresol.ui.BaseFragment;

/**
 * Created by fastwow on 25.02.2015.
 */
public class AdUserOptionFragment extends BaseDialogFragment {

    @InjectView(R.id.close)
    ImageView mCloseImageView;

    @InjectView(R.id.send_msg)
    ImageView mSendMsgImageView;

    @InjectView(R.id.like)
    ImageView mLikeImageView;

    @InjectView(R.id.make_call)
    ImageView mMakeCallImageView;

    public static Fragment newInstance() {

        AdUserOptionFragment instance = new AdUserOptionFragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_ad_user_option, container, false);

        ButterKnife.inject(this, mRoot);

        return super.onCreateView(inflater, container, savedInstanceState);
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

                    break;

                case R.id.make_call:

                    break;
            }
        }
    };
}
