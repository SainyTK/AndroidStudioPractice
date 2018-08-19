package com.tk.androidstudiopractice.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tk.androidstudiopractice.R;

public class BottomNavigationFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottomnavigation,container,false);

        BottomNavigationView bottomNav = root.findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()){
                    case R.id.bottom_menu_boat:
                        Log.d("TEST", "onNavigationItemSelected: boat");
                        return true;
                    case R.id.bottom_menu_bus:
                        Log.d("TEST", "onNavigationItemSelected: bus");
                        return true;
                    case R.id.bottom_menu_car:
                        Log.d("TEST", "onNavigationItemSelected: car");
                        return true;
                    case R.id.bottom_menu_railway:
                        Log.d("TEST", "onNavigationItemSelected: railway");
                        return true;
                }
                return false;
            }
        });

        return root;
    }
}
