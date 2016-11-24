package com.demo.panguso.rxjava_dagger2.mvp.control.impl;

import android.util.Log;

import com.demo.panguso.rxjava_dagger2.R;
import com.demo.panguso.rxjava_dagger2.app.App;
import com.demo.panguso.rxjava_dagger2.common.Contants;
import com.demo.panguso.rxjava_dagger2.mvp.control.NewsChannelControl;
import com.demo.panguso.rxjava_dagger2.mvp.listener.RequestCallback;
import com.demo.panguso.rxjava_dagger2.repository.NewsChannelTabMannager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import greendao.NewsChannelTable;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by ${yangfang} on 2016/11/24.
 */

public class NewsChannelControlImpl implements NewsChannelControl<Map<Integer, List<NewsChannelTable>>> {
    @Inject
    public NewsChannelControlImpl() {
    }

    @Override
    public Subscription loadNewsChannels(final RequestCallback<Map<Integer, List<NewsChannelTable>>> callback) {
        return Observable.create(new Observable.OnSubscribe<Map<Integer, List<NewsChannelTable>>>() {
            @Override
            public void call(Subscriber<? super Map<Integer, List<NewsChannelTable>>> subscriber) {
                Map<Integer, List<NewsChannelTable>> newsChannelTable = getNewsChannelData();
                subscriber.onNext(newsChannelTable);
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<Map<Integer, List<NewsChannelTable>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                callback.failure(App.getAppContext().getString(R.string.db_error));
            }

            @Override
            public void onNext(Map<Integer, List<NewsChannelTable>> integerListMap) {
                Log.e("TAG","NewsChannelControlImpl:"+integerListMap.size());
                callback.success(integerListMap);
            }
        });
    }

    public Map<Integer, List<NewsChannelTable>> getNewsChannelData() {
        Map<Integer, List<NewsChannelTable>> map = new HashMap<>();
        List<NewsChannelTable> channelTablesMine = NewsChannelTabMannager.loadNewsChannelsMine();
        List<NewsChannelTable> channelTablesMore = NewsChannelTabMannager.loadNewsChannelsMore();
        map.put(Contants.NEWS_CHANNEL_MINE,channelTablesMine);
        map.put(Contants.NEWS_CHANNEL_MORE,channelTablesMore);
        return map;
    }
}
