package io.yalkaev.rahat_lokum.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.yalkaev.rahat_lokum.R;
import io.yalkaev.rahat_lokum.adapter.OrderListAdapter;
import io.yalkaev.rahat_lokum.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_order;

    private List<OrderDTO> data;
    private OrderListAdapter adapter;

    public static OrderFragment getInstance(Context context, List<OrderDTO> data) {
        Bundle args = new Bundle();
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        fragment.setData(data);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_order));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        /*
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));

        adapter = new OrderListAdapter(data);
        rv.setAdapter(adapter); */

        return view;
    }


    public void setContext(Context context) {

        this.context = context;
    }

    public void setData(List<OrderDTO> data) {

        this.data = data;
    }

    public void refreshData(List<OrderDTO> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}


