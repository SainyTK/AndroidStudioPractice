package com.tk.androidstudiopractice.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tk.androidstudiopractice.R;

public class MyRecyclerAdapterH extends RecyclerView.Adapter<MyRecyclerAdapterH.Holder>{

    private String[] mDataSet;

    public interface ItemClickListener{
        void onItemClick(int position);
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textTitle;
        TextView textDescription;

        MyRecyclerAdapter.ItemClickListener mListener;

        public Holder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.text_title);
            textDescription = itemView.findViewById(R.id.text_description);

            itemView.setOnClickListener(this);
        }

        public void setData(int position){
            textTitle.setText(mDataSet[position]);
            textDescription.setText("Index : " + position);
        }

        public void setItemClickListener(MyRecyclerAdapter.ItemClickListener listener){
            mListener = listener;
        }


        @Override
        public void onClick(View view) {
            if(mListener!=null)
                mListener.onItemClick(getAdapterPosition());
        }
    }

    public MyRecyclerAdapterH(String[] dataSet){
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public MyRecyclerAdapterH.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_item_h,parent,false);
        MyRecyclerAdapterH.Holder holder = new MyRecyclerAdapterH.Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapterH.Holder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

}
