package com.demo.panguso.rxjava_dagger2.mvp.presenter.base;

/**
 * Created by ${yangfang} on 2016/11/16.
 */

public interface BasePresenter<T> {
    //做一些初始化的东西
    void onCreate();

    void attachView(T view);
}
