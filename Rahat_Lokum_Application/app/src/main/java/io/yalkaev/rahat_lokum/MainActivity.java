package io.yalkaev.rahat_lokum;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import io.yalkaev.rahat_lokum.R;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.ArrayList;

import io.yalkaev.rahat_lokum.adapter.TabsFragmentAdapter;
import io.yalkaev.rahat_lokum.dto.OrderDTO;


public class MainActivity extends AppCompatActivity {


    private static final int LAYOUT = R.layout.activity_main;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private TabsFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
        initNavigationView();
        initTabs();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new TabsFragmentAdapter(getApplicationContext(), getSupportFragmentManager(), new ArrayList<OrderDTO>());
        viewPager.setAdapter(adapter);

        new OrderTask().execute();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void showRestaurantTab()
    {
        viewPager.setCurrentItem(Constants.TAB_ONE);
    }

    private void showOrderTab()
    {
        viewPager.setCurrentItem(Constants.TAB_TWO);
    }
    private void showMenulistTab()
    {
        viewPager.setCurrentItem(Constants.TAB_THREE);
    }
    private void showServicesTab()
    {
        viewPager.setCurrentItem(Constants.TAB_FOUR);
    }
    private void showSharesTab()
    {
        viewPager.setCurrentItem(Constants.TAB_FIVE);
    }
    private void showPhotosTab()
    {
        viewPager.setCurrentItem(Constants.TAB_SIX);
    }
    private void showContactsTab()
    {
        viewPager.setCurrentItem(Constants.TAB_SEVEN);
    }


    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.actionRestaurantItem:
                        showRestaurantTab();
                        break;
                    case R.id.actionOrderItem:
                        showOrderTab();
                        break;
                    case R.id.actionMenulistItem:
                        showMenulistTab();
                        break;
                    case R.id.actionServicesItem:
                        showServicesTab();
                        break;
                    case R.id.actionSharesItem:
                        showSharesTab();
                        break;
                    case R.id.actionPhotosItem:
                        showPhotosTab();
                        break;
                    case R.id.actionContactsItem:
                        showContactsTab();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    private class OrderTask extends AsyncTask<Void, Void, OrderDTO> {
        @Override
        protected OrderDTO doInBackground(Void... voids) {
            RestTemplate template = new RestTemplate();
            template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            return template.getForObject(Constants.URL.GET_ORDER_ITEM, OrderDTO.class);
        }

        @Override
        protected void onPostExecute(OrderDTO orderDTO) {
            List<OrderDTO> list = new ArrayList<>();
            list.add(orderDTO);
            adapter.setData(list);
        }
    }
}

