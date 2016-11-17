package com.demo.panguso.rxjava_dagger2.mvp.control;


import com.demo.panguso.rxjava_dagger2.mvp.listener.RequestCallback;

/**
 * Created by ${yangfang} on 2016/11/17.
 */
public interface NewsControl<T>{
    void initChannelDatas(RequestCallback<T> callBack);
}
