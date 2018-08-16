package com.tk.androidstudiopractice.recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tk.androidstudiopractice.R;

public class RecyclerViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.from(getContext()).inflate(R.layout.fragment_recyclerview,container,false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerview);
        RecyclerView recyclerView2 = root.findViewById(R.id.recyclerview2);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        String[] strings = getContext().getResources().getStringArray(R.array.string_array);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(strings);
        adapter.setItemClickListener(new MyRecyclerAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("test", "onItemClick: index = " + position);
            }
        });
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(layoutManager2);

        MyRecyclerAdapterH adapter2 = new MyRecyclerAdapterH(strings);
        recyclerView2.setAdapter(adapter2);

        return root;
    }
}
