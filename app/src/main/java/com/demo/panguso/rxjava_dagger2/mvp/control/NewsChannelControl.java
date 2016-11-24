package com.demo.panguso.rxjava_dagger2.mvp.control;

import com.demo.panguso.rxjava_dagger2.mvp.listener.RequestCallback;

import rx.Subscription;

/**
 * Created by ${yangfang} on 2016/11/24.
 */

public interface NewsChannelControl<T>{
    Subscription loadNewsChannels(RequestCallback<T> data);
}
