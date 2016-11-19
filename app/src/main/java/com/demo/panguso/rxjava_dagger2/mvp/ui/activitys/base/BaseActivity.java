package com.demo.panguso.rxjava_dagger2.mvp.ui.activitys.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.panguso.rxjava_dagger2.app.App;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by ${yangfang} on 2016/11/16.
 */

public abstract class BaseActivity extends AppCompatActivity {
//
//    public abstract int initLayout();
//
//    public abstract void initView();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initLayout();
//        initView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refwatcher = App.getRefWatcher(this);
        refwatcher.watch(this);
    }
}
