package com.demo.panguso.rxjava_dagger2.mvp.control;


import com.demo.panguso.rxjava_dagger2.mvp.listener.RequestCallback;

import rx.Subscription;

/**
 * Created by ${yangfang} on 2016/11/17.
 */
public interface NewsControl<T>{
    Subscription initChannelDatas(RequestCallback<T> callBack);
}
