package io.yalkaev.rahat_lokum.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.yalkaev.rahat_lokum.dto.OrderDTO;
import io.yalkaev.rahat_lokum.fragment.AbstractTabFragment;
import io.yalkaev.rahat_lokum.fragment.ContactsFragment;
import io.yalkaev.rahat_lokum.fragment.MenulistFragment;
import io.yalkaev.rahat_lokum.fragment.OrderFragment;
import io.yalkaev.rahat_lokum.fragment.PhotosFragment;
import io.yalkaev.rahat_lokum.fragment.RestaurantFragment;
import io.yalkaev.rahat_lokum.fragment.ServicesFragment;
import io.yalkaev.rahat_lokum.fragment.SharesFragment;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;
    private List<OrderDTO> data;
    private RestaurantFragment restaurantFragment;
    private OrderFragment orderFragment;
    private MenulistFragment menulistFragment;
    private ServicesFragment servicesFragment;
    private SharesFragment sharesFragment;
    private PhotosFragment photosFragment;
    private ContactsFragment contactsFragment;

    public TabsFragmentAdapter(Context context, FragmentManager fm, List<OrderDTO> data) {
        super(fm);
        this.context = context;
        this.data = new ArrayList<>();
        initTabMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {

        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabMap(Context context) {
        tabs = new HashMap<>();
        restaurantFragment = RestaurantFragment.getInstance(context);
        orderFragment = OrderFragment.getInstance(context, data);
        menulistFragment = MenulistFragment.getInstance(context);
        servicesFragment = ServicesFragment.getInstance(context);
        sharesFragment = SharesFragment.getInstance(context);
        photosFragment = PhotosFragment.getInstance(context);
        contactsFragment = ContactsFragment.getInstance(context);

        tabs.put(0, restaurantFragment);
        tabs.put(1, orderFragment);
        tabs.put(2, menulistFragment);
        tabs.put(3, servicesFragment);
        tabs.put(4, sharesFragment);
        tabs.put(5, photosFragment);
        tabs.put(6, contactsFragment);
    }

    public void setData(List<OrderDTO> data) {
        this.data = data;
        orderFragment.refreshData(data);
    }
}
