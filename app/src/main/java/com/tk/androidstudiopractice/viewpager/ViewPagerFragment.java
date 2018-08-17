package com.tk.androidstudiopractice.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tk.androidstudiopractice.R;

public class ViewPagerFragment extends Fragment{

    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.from(getContext()).inflate(R.layout.fragment_viewpager,container,false);

        viewPager = root.findViewById(R.id.pager);

        String[] dataSet = getContext().getResources().getStringArray(R.array.string_array);

        MyPagerAdapter adapter = new MyPagerAdapter(getContext(),dataSet);
        viewPager.setAdapter(adapter);

        return root;
    }
}
