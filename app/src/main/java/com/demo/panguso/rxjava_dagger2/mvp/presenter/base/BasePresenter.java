package com.demo.panguso.rxjava_dagger2.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.demo.panguso.rxjava_dagger2.mvp.view.base.BaseView;

/**
 * Created by ${yangfang} on 2016/11/16.
 */

public interface BasePresenter {
    //做一些初始化的东西
    void onCreate();

    void attachView(@NonNull BaseView view);
}
