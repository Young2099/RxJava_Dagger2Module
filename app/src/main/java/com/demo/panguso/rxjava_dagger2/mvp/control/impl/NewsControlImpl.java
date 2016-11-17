package com.demo.panguso.rxjava_dagger2.mvp.control.impl;

import com.demo.panguso.rxjava_dagger2.mvp.control.NewsControl;
import com.demo.panguso.rxjava_dagger2.mvp.listener.RequestCallback;

import java.util.List;

import greendao.NewsChannelTable;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public class NewsControlImpl implements NewsControl<List<NewsChannelTable>> {


    @Override
    public void initChannelDatas(final RequestCallback<List<NewsChannelTable>> callBack) {

    }
}
