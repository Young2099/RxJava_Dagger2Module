package com.demo.panguso.rxjava_dagger2.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.panguso.rxjava_dagger2.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public class NewsFragment extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mRecyclerView.setHasFixedSize(true);

    }
}
