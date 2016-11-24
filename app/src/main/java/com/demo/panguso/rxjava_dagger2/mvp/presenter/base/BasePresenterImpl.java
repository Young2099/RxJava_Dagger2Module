package com.demo.panguso.rxjava_dagger2.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.demo.panguso.rxjava_dagger2.mvp.listener.RequestCallback;
import com.demo.panguso.rxjava_dagger2.mvp.view.base.BaseView;

/**
 * Created by ${yangfang} on 2016/11/24.
 */

public class BasePresenterImpl<T extends BaseView,E> implements BasePresenter,RequestCallback<E> {
    protected T mView;

    @Override
    public void onCreate() {

    }

    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (T) view;
    }

    @Override
    public void success(E data) {

    }

    @Override
    public void failure(String errormsg) {

    }
}
