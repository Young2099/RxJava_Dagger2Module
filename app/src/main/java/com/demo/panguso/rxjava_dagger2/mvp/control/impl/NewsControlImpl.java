package com.demo.panguso.rxjava_dagger2.mvp.control.impl;


import android.util.Log;

import com.demo.panguso.rxjava_dagger2.mvp.control.NewsControl;
import com.demo.panguso.rxjava_dagger2.mvp.listener.RequestCallback;
import com.demo.panguso.rxjava_dagger2.repository.NewsChannelTabMannager;

import java.util.List;

import greendao.NewsChannelTable;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public class NewsControlImpl implements NewsControl<List<NewsChannelTable>> {


    @Override
    public Subscription initChannelDatas(final RequestCallback<List<NewsChannelTable>> callBack) {
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>() {
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                NewsChannelTabMannager.initDB();
                subscriber.onNext(NewsChannelTabMannager.loadNewsChannelsMine());
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NewsChannelTable>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<NewsChannelTable> newsChannelTables) {
                        callBack.success(newsChannelTables);
                        Log.e("TAG","newLLL"+newsChannelTables.size());
                    }
                });
    }
}
