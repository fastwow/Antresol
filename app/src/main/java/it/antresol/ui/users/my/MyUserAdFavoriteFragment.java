package it.antresol.ui.users.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.antresol.ui.BaseFragment;

/**
 * Created by fastwow on 28.02.2015.
 */
public class MyUserAdFavoriteFragment extends BaseFragment {


    public static BaseFragment newInstance() {

        MyUserAdFavoriteFragment instance = new MyUserAdFavoriteFragment();

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
