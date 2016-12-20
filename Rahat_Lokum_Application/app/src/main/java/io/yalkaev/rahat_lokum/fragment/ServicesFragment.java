package io.yalkaev.rahat_lokum.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.yalkaev.rahat_lokum.R;

public class ServicesFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_services;

    public static ServicesFragment getInstance(Context context) {
        Bundle args = new Bundle();
        ServicesFragment fragment = new ServicesFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_services));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);


        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}


