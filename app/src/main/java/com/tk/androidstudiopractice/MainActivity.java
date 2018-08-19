package com.tk.androidstudiopractice;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.tk.androidstudiopractice.bottomnavigation.BottomNavigationFragment;
import com.tk.androidstudiopractice.bottomsheet.BottomSheetFragment;
import com.tk.androidstudiopractice.cardview.CardViewFragment;
import com.tk.androidstudiopractice.recyclerview.RecyclerViewFragment;
import com.tk.androidstudiopractice.viewpager.ViewPagerFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    Fragment currentFragment;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()){
            case R.id.menu_card_view:
                currentFragment = new CardViewFragment();
                break;
            case R.id.menu_recycler_view:
                currentFragment = new RecyclerViewFragment();
                break;
            case R.id.menu_view_pager:
                currentFragment = new ViewPagerFragment();
                break;
            case R.id.menu_bottom_navigator:
                currentFragment = new BottomNavigationFragment();
                break;
            case R.id.menu_bottom_sheet:
                currentFragment = new BottomSheetFragment();
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,currentFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();

        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
