package com.demo.panguso.rxjava_dagger2.mvp.presenter.impl;

import com.demo.panguso.rxjava_dagger2.mvp.bean.NewsDetail;
import com.demo.panguso.rxjava_dagger2.mvp.listener.RequestCallback;
import com.demo.panguso.rxjava_dagger2.mvp.presenter.NewsPresenter;
import com.demo.panguso.rxjava_dagger2.mvp.control.NewsControl;
import com.demo.panguso.rxjava_dagger2.mvp.control.impl.NewsControlImpl;
import com.demo.panguso.rxjava_dagger2.mvp.view.NewsView;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public class NewsPresenterImpl implements NewsPresenter,RequestCallback<NewsDetail>{
    NewsView mView;
    NewsControl mInteractImpl;
    public NewsPresenterImpl(){
        mInteractImpl = new NewsControlImpl();
    }

    @Override
    public void onCreate() {
        mInteractImpl.initChannelDatas(this);
    }

    @Override
    public void attachView(NewsView view) {
        mView = view;
    }

    @Override
    public void success(NewsDetail data) {

    }

    @Override
    public void failure(String errormsg) {

    }
}
