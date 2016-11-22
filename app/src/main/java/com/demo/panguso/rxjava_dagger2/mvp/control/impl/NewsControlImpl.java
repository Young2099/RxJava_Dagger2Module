package com.demo.panguso.rxjava_dagger2.mvp.control.impl;


import android.os.Looper;

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

    /**
     * 判断是否在在主线程
     *
     * @return
     */
    public static boolean isInMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override
    public Subscription initChannelDatas(final RequestCallback<List<NewsChannelTable>> callBack) {
//        NewsChannelTabMannager.initDB();
//        final List<NewsChannelTable> list = NewsChannelTabMannager.loadNewsChannelsMine();
//        Log.e("TAG", "////" + list.size());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                callBack.success(list);
//                Log.i("TAG", "Test In NOT in MainThread isMainThread="
//                        + isInMainThread());
//            }
//        }).start();
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
                        callBack.failure("网络连接失败");
                    }

                    @Override
                    public void onNext(List<NewsChannelTable> newsChannelTables) {
                        callBack.success(newsChannelTables);
                    }
                });
    }
}
