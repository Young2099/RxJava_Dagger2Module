package com.demo.panguso.rxjava_dagger2.mvp.view;

import com.demo.panguso.rxjava_dagger2.mvp.view.base.BaseView;

import java.util.List;

import greendao.NewsChannelTable;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public interface NewsView extends BaseView {
    void initChannelData(List<NewsChannelTable> data);
}
