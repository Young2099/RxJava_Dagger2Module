package com.demo.panguso.rxjava_dagger2.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.demo.panguso.rxjava_dagger2.app.App;
import com.demo.panguso.rxjava_dagger2.di.component.DaggerFragmentComponent;
import com.demo.panguso.rxjava_dagger2.di.component.FragmentComponent;
import com.demo.panguso.rxjava_dagger2.di.module.FragmentModule;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public class BaseFragment extends Fragment {
    protected FragmentComponent mFragmentComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注入fragment到FragmentComponent里面去
        mFragmentComponent = DaggerFragmentComponent.builder()
                .appComponent(((App) getActivity().getApplication()).getmAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }
}
