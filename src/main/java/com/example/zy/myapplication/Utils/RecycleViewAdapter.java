package com.example.zy.myapplication.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.zy.myapplication.R;

import java.util.List;

/**
 * @author wwq
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyHolder>{
    private Context mContext;
    private List<Integer> datas;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public RecycleViewAdapter(Context mContext, List<Integer> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }


    @NonNull
    @Override
    public RecycleViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView= LayoutInflater.from(mContext).inflate(R.layout.recycly_item_layout,null);
        MyHolder myHolder=new MyHolder(mView);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyHolder holder, int position) {

        holder.mImageview.setImageResource(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private ImageView mImageview;

        public MyHolder(View itemView) {
            super(itemView);
            this.mImageview = (ImageView) itemView.findViewById(R.id.iv_pictures);
        }
    }
}
