package com.demo.panguso.rxjava_dagger2.di.module;

import android.support.v4.app.Fragment;

import com.demo.panguso.rxjava_dagger2.di.scope.ContextLife;
import com.demo.panguso.rxjava_dagger2.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${yangfang} on 2016/11/28.
 */
@Module
public class FragmentModule {
    Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        this.mFragment = fragment;
    }

    @ContextLife("Fragment")
    @PerFragment
    @Provides
    public Fragment providerFragment() {
        return mFragment;
    }
}
