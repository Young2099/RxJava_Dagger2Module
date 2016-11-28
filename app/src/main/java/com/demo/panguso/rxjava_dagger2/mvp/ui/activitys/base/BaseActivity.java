package com.demo.panguso.rxjava_dagger2.mvp.ui.activitys.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.panguso.rxjava_dagger2.app.App;
import com.demo.panguso.rxjava_dagger2.di.component.ActivityComponent;
import com.demo.panguso.rxjava_dagger2.di.component.DaggerActivityComponent;
import com.demo.panguso.rxjava_dagger2.di.module.ActivityModule;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;


/**
 * Created by ${yangfang} on 2016/11/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int initLayout();

    protected abstract void initInject();

    public abstract void initView();

    public ActivityComponent mActivityComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(((App) getApplication()).getmAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
        setContentView(initLayout());
        initInject();
        ButterKnife.bind(this);
        initView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refwatcher = App.getRefWatcher(this);
        refwatcher.watch(this);
    }
}
