package com.demo.panguso.rxjava_dagger2.mvp.ui.activitys;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.demo.panguso.rxjava_dagger2.R;
import com.demo.panguso.rxjava_dagger2.mvp.presenter.impl.NewsChannelPresenterImpl;
import com.demo.panguso.rxjava_dagger2.mvp.ui.activitys.base.BaseActivity;
import com.demo.panguso.rxjava_dagger2.mvp.ui.adapter.NewsChannelAdapter;
import com.demo.panguso.rxjava_dagger2.mvp.view.NewsChannelView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import greendao.NewsChannelTable;

public class NewsChannelActivity extends BaseActivity implements NewsChannelView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.news_channel_mine_rv)
    RecyclerView mNewsChannelMineRV;
    @BindView(R.id.news_channel_more_iv)
    RecyclerView mNewsChannelMoreRV;
    @Inject
    NewsChannelPresenterImpl mNewsChannelPresenter;

    NewsChannelAdapter mChannelAdapterMine;
    NewsChannelAdapter mChannelAdapterMore;

    @Override
    public int initLayout() {
        return R.layout.activity_news_channel;
    }

    @Override
    protected void initInject() {
        mActivityComponent.inject(this);
    }

    @Override
    public void initView() {
        mNewsChannelPresenter.attachView(this);
        mNewsChannelPresenter.onCreate();
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

    @Override
    public void initRecyclerViews(List<NewsChannelTable> newsChannelTablesMine, List<NewsChannelTable> newsChannelTablesMore) {
        Log.e("NewsChannelTable", "dddd" + newsChannelTablesMine.size());
        initRecyclerViewMineAndMore(newsChannelTablesMine, newsChannelTablesMore);
    }

    private void initRecyclerViewMineAndMore(List<NewsChannelTable> newsChannelTablesMine, List<NewsChannelTable> newsChannelTablesMore) {
        initRecyclerViews(mNewsChannelMineRV, newsChannelTablesMine, true);
        initRecyclerViews(mNewsChannelMoreRV, newsChannelTablesMore, false);
    }

    private void initRecyclerViews(RecyclerView recyclerview, List<NewsChannelTable> newsChannelTable, boolean isChannelMine) {
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        if (isChannelMine) {
            mChannelAdapterMine = new NewsChannelAdapter(newsChannelTable);
            recyclerview.setAdapter(mChannelAdapterMine);
        } else {
            mChannelAdapterMore = new NewsChannelAdapter(newsChannelTable);
            recyclerview.setAdapter(mChannelAdapterMore);
        }

    }
}
