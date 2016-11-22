package com.demo.panguso.rxjava_dagger2.di.module;

import android.app.Application;

import com.demo.panguso.rxjava_dagger2.app.App;
import com.demo.panguso.rxjava_dagger2.di.scope.ContextLife;
import com.demo.panguso.rxjava_dagger2.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${yangfang} on 2016/11/22.
 **/

@Module//提供依赖，Components从根本上来说就是一个注入器，也可以说是@Inject和@Module的桥梁。
public class AppModule {
    App mApplication;

    public AppModule(App application) {
        mApplication = application;
    }

    @Provides//提供Application的全局实例
    @PerApp
    @ContextLife("Application")
    public Application providersApplication() {
        return mApplication;
    }
}
