package com.demo.panguso.rxjava_dagger2.di.component;

import android.app.Application;

import com.demo.panguso.rxjava_dagger2.di.module.AppModule;
import com.demo.panguso.rxjava_dagger2.di.scope.ContextLife;
import com.demo.panguso.rxjava_dagger2.di.scope.PerApp;

import dagger.Component;

/**
 * Created by ${yangfang} on 2016/11/22.
 */
@PerApp
@Component(modules = {AppModule.class})//主要是用于模块注入的代码
public interface AppComponent {
    @ContextLife("Application")
    Application getApplication();
}
