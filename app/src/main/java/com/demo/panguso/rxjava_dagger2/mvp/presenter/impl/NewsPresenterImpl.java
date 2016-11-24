package com.demo.panguso.rxjava_dagger2.mvp.presenter.impl;

import com.demo.panguso.rxjava_dagger2.mvp.control.NewsControl;
import com.demo.panguso.rxjava_dagger2.mvp.control.impl.NewsControlImpl;
import com.demo.panguso.rxjava_dagger2.mvp.presenter.NewsPresenter;
import com.demo.panguso.rxjava_dagger2.mvp.presenter.base.BasePresenterImpl;
import com.demo.panguso.rxjava_dagger2.mvp.view.NewsView;

import java.util.List;

import javax.inject.Inject;

import greendao.NewsChannelTable;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public class NewsPresenterImpl extends BasePresenterImpl<NewsView, List<NewsChannelTable>> implements NewsPresenter {
    NewsControl mInteractImpl;

    @Inject
    public NewsPresenterImpl() {
        mInteractImpl = new NewsControlImpl();
    }

    @Override
    public void onCreate() {
        mInteractImpl.initChannelDatas(this);
    }

    @Override
    public void success(List<NewsChannelTable> data) {
        super.success(data);
        mView.initChannelData(data);
    }

    @Override
    public void failure(String errormsg) {
        super.failure(errormsg);
        mView.showErrMessage();
    }
}
