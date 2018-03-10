package com.lucky.wsy.wzxproject.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lucky.wsy.wzxproject.R;
import com.lucky.wsy.wzxproject.bean.MainData;

import java.util.List;

/**
 * Created by wsy on 2018/3/4.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    private List<MainData> dataList;

    private LayoutInflater layoutInflater;


    public MainRecyclerAdapter(List<MainData> dataList, LayoutInflater layoutInflater) {
        this.dataList = dataList;
        this.layoutInflater = layoutInflater;

    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.main_recycler_item_adp, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        holder.tvName.setText(dataList.get(position).getName());
        if (mListener != null) {
            //绑定点击事件
            holder.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //把条目的位置回调回去
                    mListener.onItemClick(position);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;

        MainViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }

    public ItemClickListener mListener;

    public void setOnItemClickListener(ItemClickListener listener) {
        this.mListener = listener;
    }
}
