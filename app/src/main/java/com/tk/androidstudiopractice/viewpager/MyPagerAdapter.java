package com.tk.androidstudiopractice.viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tk.androidstudiopractice.R;

public class MyPagerAdapter extends PagerAdapter{

    private String[] mDataSet;
    private Context mContext;

    public MyPagerAdapter(Context context,String[] dataSet){
        mContext = context;
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_pager_item,container,false);

        setData(view,position);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public int getCount() {
        return mDataSet.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(View)object);
    }

    private void setData(View view,int position){
        TextView textPageTitle = view.findViewById(R.id.text_pager_title);
        textPageTitle.setText(mDataSet[position]);
    }
}

//public class MyPagerAdapter extends PagerAdapter {
//
//    private String[] mDataSet;
//    private Context mContext;
//
//    public MyPagerAdapter(Context context,String[] dataSet){
//        mContext = context;
//        mDataSet = dataSet;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_pager_item,container,false);
//
//        setData(view,position);
//
//        container.addView(view);
//        return view;
//    }
//
//    @Override
//    public int getCount() {
//        return mDataSet.length;
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return (view==(View)object);
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        ((ViewPager) container).removeView((View)object);
//    }
//
//    private void setData(View view, int position){
//        TextView textPagerTitle = view.findViewById(R.id.text_pager_title);
//
//        textPagerTitle.setText(mDataSet[position]);
//    }
//}