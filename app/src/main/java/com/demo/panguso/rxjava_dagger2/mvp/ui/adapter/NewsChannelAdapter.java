package com.demo.panguso.rxjava_dagger2.mvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.panguso.rxjava_dagger2.R;
import com.demo.panguso.rxjava_dagger2.app.App;

import java.util.ArrayList;
import java.util.List;

import greendao.NewsChannelTable;

/**
 * Created by ${yangfang} on 2016/11/24.
 */

public class NewsChannelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<NewsChannelTable> data = new ArrayList<>();
    public NewsChannelAdapter(List<NewsChannelTable> data) {
        Log.e("TAG","data:"+data.size());
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ChannelViewHolder viewHolder;
        View view = LayoutInflater.from(App.getAppContext()).inflate(R.layout.item_layout,parent,false);
        viewHolder = new ChannelViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof ChannelViewHolder){
                ((ChannelViewHolder) holder).mTextView.setText(data.get(position).getNewsChannelName());
            }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ChannelViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        public ChannelViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_channel);
        }
    }
}
