package it.antresol.ui.users.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;

import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.antresol.R;
import it.antresol.api.AntresolAPIManager;
import it.antresol.api.IRequestStatusListener;
import it.antresol.model.CreateUserBody;
import it.antresol.model.CurrentUser;
import it.antresol.ui.BaseFragment;
import it.antresol.utils.PreferenceHelper;

/**
 * Created by fastwow on 28.02.2015.
 */
public class MyUserLoginFragment extends BaseFragment implements IRequestStatusListener<CurrentUser> {

    public static final String TAG = MyUserLoginFragment.class.getSimpleName();

    private UiLifecycleHelper uiHelper;

    @InjectView(R.id.antresol_image)
    ImageView mAntresolImageView;

    @InjectView(R.id.login_fb_container)
    View mLoginFbView;

    @InjectView(R.id.login_vk_container)
    View mLoginVkView;

    private View.OnClickListener mLoginBtnOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.login_vk_container:


                    break;

                case R.id.login_fb_container:

                    facebookLoginBtnOnClick();
                    break;
            }
        }
    };

    private void getUserInfo(final Session session) {

        if (mUIEventListener != null)
            mUIEventListener.showProgressBar();

        Request.newMeRequest(session, new Request.GraphUserCallback() {
            @Override
            public void onCompleted(GraphUser user, Response response) {

                if (response != null && session == Session.getActiveSession()) {

                    try {

                        String lastName = user.getLastName();
                        String firstName = user.getLastName();
                        String token = Session.getActiveSession().getAccessToken();
                        Log.d(TAG, "Name: " + lastName + " Email: " + firstName);

                        CreateUserBody createUser = new CreateUserBody(lastName, firstName,
                                CreateUserBody.PROVIDER_FACEBOOK, user.getId(), token);
                        AntresolAPIManager.getInstance().createUser(MyUserLoginFragment.this, createUser);
                    } catch (Exception e) {

                        e.printStackTrace();
                        Log.d(TAG, "Exception e");


                        if (mUIEventListener != null)
                            mUIEventListener.dismissProgressBar();
                    }
                }
            }
        }).executeAsync();
    }

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {

        getUserInfo(session);
    }

    private Session.StatusCallback statusCallback =
            new SessionStatusCallback();

    @Override
    public void startFetchDataFromServer() {

    }

    @Override
    public void onSuccess(CurrentUser result, boolean isNeedToRefreshData) {

    }

    @Override
    public void onSuccess(CurrentUser user) {

        if (mUIEventListener != null)
            mUIEventListener.dismissProgressBar();

        Log.d(TAG, "onSuccess.result = " + user);

        PreferenceHelper.getInstance(getApp()).setCurrentUser(user);

        getFragmentManager().beginTransaction()
                .replace(R.id.container, MyUserProfileFragment.newInstance())
                .commit();
    }

    @Override
    public void onError() {

        if (mUIEventListener != null)
            mUIEventListener.dismissProgressBar();
    }

    @Override
    public void onError(String text) {

    }

    private class SessionStatusCallback implements Session.StatusCallback {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            // Respond to session state changes, ex: updating the view

            if (state.isOpened()) {

                Log.i(TAG, "Logged in...");
                getUserInfo(session);
            } else if (state.isClosed()) {

                Log.i(TAG, "Logged out...");
            }

            onSessionStateChange(session, state, exception);
        }
    }

    private void facebookLoginBtnOnClick() {

        Session session = Session.getActiveSession();
        if (session != null) {
            if (!session.isOpened() && !session.isClosed()) {
                session.openForRead(new Session.OpenRequest(this)
                        .setPermissions(Arrays.asList("public_profile", "user_friends", "email", "user_likes"))
                        .setCallback(statusCallback));
            } else {
                Session.openActiveSession(getActivity(), this, true, statusCallback);
            }
        }
    }

    public static Fragment newInstance() {

        MyUserLoginFragment instance = new MyUserLoginFragment();

        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        uiHelper = new UiLifecycleHelper(getActivity(), statusCallback);
        uiHelper.onCreate(savedInstanceState);

        if (getActionBar() != null) {

            getActionBar().setTitle(R.string.login);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_my_user_login, container, false);

        ButterKnife.inject(this, mRootView);

        mPicasso.load(R.drawable.login_bg)
//                .error(android.R.drawable.stat_notify_error)
//                .placeholder(android.R.drawable.stat_notify_sync)
                .into(mAntresolImageView);

        mLoginVkView.setOnClickListener(mLoginBtnOnClickListener);
        mLoginFbView.setOnClickListener(mLoginBtnOnClickListener);

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        Session session = Session.getActiveSession();
        if (session != null &&
                (session.isOpened() || session.isClosed())) {

            onSessionStateChange(session, session.getState(), null);
        }

        uiHelper.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);

    }
}
