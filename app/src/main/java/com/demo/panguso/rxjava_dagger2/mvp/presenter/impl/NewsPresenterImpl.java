package com.demo.panguso.rxjava_dagger2.mvp.presenter.impl;

import android.util.Log;

import com.demo.panguso.rxjava_dagger2.mvp.control.NewsControl;
import com.demo.panguso.rxjava_dagger2.mvp.control.impl.NewsControlImpl;
import com.demo.panguso.rxjava_dagger2.mvp.listener.RequestCallback;
import com.demo.panguso.rxjava_dagger2.mvp.presenter.NewsPresenter;
import com.demo.panguso.rxjava_dagger2.mvp.view.NewsView;

import java.util.List;

import greendao.NewsChannelTable;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public class NewsPresenterImpl implements NewsPresenter,RequestCallback<List<NewsChannelTable>>{
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
    public void success(List<NewsChannelTable> data) {
        Log.e("/////////","data"+data.size());
        mView.initChannelData(data);

    }

    @Override
    public void failure(String errormsg) {

    }
}
