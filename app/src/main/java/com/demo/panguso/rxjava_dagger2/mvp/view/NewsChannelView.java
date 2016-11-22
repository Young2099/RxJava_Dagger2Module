package com.demo.panguso.rxjava_dagger2.mvp.view;

import com.demo.panguso.rxjava_dagger2.mvp.view.base.BaseView;

import java.util.List;

import greendao.NewsChannelTable;

/**
 * Created by ${yangfang} on 2016/11/21.
 */

public interface NewsChannelView extends BaseView{
    void initRecyclerViews(List<NewsChannelTable> list);
}
