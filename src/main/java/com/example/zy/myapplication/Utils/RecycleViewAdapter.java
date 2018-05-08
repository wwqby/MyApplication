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
    private OnItemClickListener mOnItemClickListener;

    public RecycleViewAdapter(Context mContext, List<Integer> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }


    public interface OnItemClickListener{
        void ItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.mOnItemClickListener=itemClickListener;
    }
    @NonNull
    @Override
    public RecycleViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView= LayoutInflater.from(mContext).inflate(R.layout.recycly_item_layout,null);
        MyHolder myHolder=new MyHolder(mView);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyHolder holder, final int position) {

        holder.mImageview.setImageResource(datas.get(position).intValue());
        if (mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.ItemClick(v,position);
                }
            });
        }
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
