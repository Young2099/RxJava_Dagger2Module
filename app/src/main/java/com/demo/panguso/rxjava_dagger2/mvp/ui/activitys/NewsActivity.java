package com.demo.panguso.rxjava_dagger2.mvp.ui.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.panguso.rxjava_dagger2.R;

import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
    }
}
