package com.demo.panguso.rxjava_dagger2.mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${yangfang} on 2016/11/17.
 */
public class NewsFragmentPageAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    public NewsFragmentPageAdapter(FragmentManager fm, List<Fragment> newsFragmentList, List<String> titles) {
        super(fm);
        this.titles = titles;
        fragmentList = newsFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }
}
