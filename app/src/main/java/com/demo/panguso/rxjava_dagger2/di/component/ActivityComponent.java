package com.demo.panguso.rxjava_dagger2.di.component;

import com.demo.panguso.rxjava_dagger2.di.module.ActivityModule;
import com.demo.panguso.rxjava_dagger2.di.scope.PerActivity;
import com.demo.panguso.rxjava_dagger2.mvp.ui.activitys.NewsActivity;
import com.demo.panguso.rxjava_dagger2.mvp.ui.activitys.NewsChannelActivity;

import dagger.Component;

/**
 * Created by ${yangfang} on 2016/11/22.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(NewsActivity newsActivity);

    void inject(NewsChannelActivity newsChannelActivity);
}
