package com.demo.panguso.rxjava_dagger2.di.component;

import com.demo.panguso.rxjava_dagger2.di.module.FragmentModule;
import com.demo.panguso.rxjava_dagger2.di.scope.PerFragment;
import com.demo.panguso.rxjava_dagger2.mvp.ui.fragment.NewsFragment;

import dagger.Component;

/**
 * Created by ${yangfang} on 2016/11/28.
 */
@PerFragment
@Component(dependencies = AppComponent.class,modules = {FragmentModule.class})
public interface FragmentComponent {
    void inject(NewsFragment newsFragment);
}
