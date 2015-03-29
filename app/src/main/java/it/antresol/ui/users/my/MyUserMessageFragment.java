package it.antresol.ui.users.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.antresol.ui.BaseFragment;

/**
 * Created by artem on 3/29/15.
 */
public class MyUserMessageFragment extends BaseFragment {

    public static BaseFragment newInstance() {

        MyUserMessageFragment instance = new MyUserMessageFragment();

        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
