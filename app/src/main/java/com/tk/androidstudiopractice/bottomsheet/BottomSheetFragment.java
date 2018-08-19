package com.tk.androidstudiopractice.bottomsheet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tk.androidstudiopractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomSheetFragment extends Fragment {

    BottomSheetBehavior bottomSheetBehavior;

    @BindView(R.id.bottom_sheet)
    View bottomSheet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.from(getContext()).inflate(R.layout.fragment_bottomsheet, container, false);
        View bottomSheetLayout = inflater.from(getContext()).inflate(R.layout.layout_bottomsheet, (ViewGroup) root, true);

        ButterKnife.bind(this, root);
        ButterKnife.bind(this, bottomSheetLayout);

        ((ViewGroup) root).removeView(bottomSheetLayout);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        return root;
    }

    @OnClick({R.id.content_container,R.id.text_bottom_sheet})
    void hideBottomSheet(){
        if(bottomSheetBehavior.getState()==BottomSheetBehavior.STATE_EXPANDED)
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @OnClick(R.id.text_bottom_sheet)
    void greeting(View view){
        Log.d("Test", "greeting: BOTTOM SHEET!!");
    }

}
