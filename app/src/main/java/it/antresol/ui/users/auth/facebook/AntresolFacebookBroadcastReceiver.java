package it.antresol.ui.users.auth.facebook;

import android.os.Bundle;
import android.util.Log;

import com.facebook.FacebookBroadcastReceiver;

/**
 * Created by artem on 3/15/15.
 */
public class AntresolFacebookBroadcastReceiver extends FacebookBroadcastReceiver {

    private static final String TAG = AntresolFacebookBroadcastReceiver.class.getSimpleName();

    @Override
    protected void onSuccessfulAppCall(String appCallId, String action, Bundle extras) {

        // A real app could update UI or notify the user that their photo was uploaded.
        Log.d(TAG, String.format("Photo uploaded by call " + appCallId + " succeeded."));
    }

    @Override
    protected void onFailedAppCall(String appCallId, String action, Bundle extras) {

        // A real app could update UI or notify the user that their photo was not uploaded.
        Log.d(TAG, String.format("Photo uploaded by call " + appCallId + " failed."));
    }
}