package com.demo.panguso.rxjava_dagger2.mvp.listener;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public interface RequestCallback<T> {
    void success(T data);

    void failure(String errormsg);
}
