package com.demo.panguso.rxjava_dagger2.mvp.presenter.impl;

import android.util.Log;

import com.demo.panguso.rxjava_dagger2.common.Contants;
import com.demo.panguso.rxjava_dagger2.mvp.control.NewsChannelControl;
import com.demo.panguso.rxjava_dagger2.mvp.control.impl.NewsChannelControlImpl;
import com.demo.panguso.rxjava_dagger2.mvp.presenter.NewsPresenter;
import com.demo.panguso.rxjava_dagger2.mvp.presenter.base.BasePresenterImpl;
import com.demo.panguso.rxjava_dagger2.mvp.view.NewsChannelView;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import greendao.NewsChannelTable;

/**
 * Created by ${yangfang} on 2016/11/21.
 */

public class NewsChannelPresenterImpl extends BasePresenterImpl<NewsChannelView, Map<Integer, List<NewsChannelTable>>> implements NewsPresenter {
    NewsChannelControl mNewsChannelControl;

    @Inject
    public NewsChannelPresenterImpl(NewsChannelControlImpl newsChannelControl) {
        mNewsChannelControl = newsChannelControl;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mNewsChannelControl.loadNewsChannels(this);
    }

    @Override
    public void success(Map<Integer, List<NewsChannelTable>> data) {
        super.success(data);
        Log.e("NewsChannelPresenter","////"+data.size());
        mView.initRecyclerViews(data.get(Contants.NEWS_CHANNEL_MINE), data.get(Contants.NEWS_CHANNEL_MORE));
    }

    @Override
    public void failure(String errormsg) {
        super.failure(errormsg);
        mView.showErrMessage();
    }
}
