package com.demo.panguso.rxjava_dagger2.di.module;

import android.app.Activity;

import com.demo.panguso.rxjava_dagger2.di.scope.ContextLife;
import com.demo.panguso.rxjava_dagger2.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${yangfang} on 2016/11/22.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @PerActivity
    @Provides
    @ContextLife("Activity")
    public Activity provideActivity() {
        return mActivity;
    }
}
