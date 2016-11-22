package com.demo.panguso.rxjava_dagger2.mvp.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.demo.panguso.rxjava_dagger2.R;
import com.demo.panguso.rxjava_dagger2.mvp.ui.activitys.base.BaseActivity;
import com.demo.panguso.rxjava_dagger2.mvp.view.NewsChannelView;

import java.util.List;

import butterknife.BindView;
import greendao.NewsChannelTable;

public class NewsChannelActivity extends BaseActivity implements NewsChannelView{
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.news_channel_mine_rv)
    RecyclerView mNewsChannelMineRV;
    @BindView(R.id.news_channel_more_iv)
    RecyclerView mNewsChannelMoreRV;


    @Override
    public int initLayout() {
        return R.layout.activity_news_channel;
    }

    @Override
    public void initView() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initRecyclerViews(List<NewsChannelTable> list) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showErrMessage() {

    }
}
