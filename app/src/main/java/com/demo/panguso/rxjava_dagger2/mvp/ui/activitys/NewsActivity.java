package com.demo.panguso.rxjava_dagger2.mvp.ui.activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.demo.panguso.rxjava_dagger2.R;
import com.demo.panguso.rxjava_dagger2.mvp.presenter.impl.NewsPresenterImpl;
import com.demo.panguso.rxjava_dagger2.mvp.ui.activitys.base.BaseActivity;
import com.demo.panguso.rxjava_dagger2.mvp.ui.adapter.NewsFragmentPageAdapter;
import com.demo.panguso.rxjava_dagger2.mvp.ui.fragment.NewsFragment;
import com.demo.panguso.rxjava_dagger2.mvp.view.NewsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends BaseActivity implements NewsView {
    NewsPresenterImpl mPresenter = new NewsPresenterImpl();

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.nav)
    NavigationView mNav;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.tab)
    TabLayout mTab;

    private String[] titles= new String[]{"头条", "科技", "财经"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        mPresenter.onCreate();
        mPresenter.attachView(this);
        initDrawerLayout();
        initView();
    }

    private void initView() {
        initFragment();
    }


    private void initFragment() {
        List<Fragment> newsFragmentList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(String t:titles){
            newsFragmentList.add(new NewsFragment());
            list.add(t);
        }
        NewsFragmentPageAdapter adapter = new NewsFragmentPageAdapter(getSupportFragmentManager(),newsFragmentList,list);
        mViewPager.setAdapter(adapter);
        mTab.setupWithViewPager(mViewPager);
    }

    private void initDrawerLayout() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.open_drawer_layout, R.string.close_drawer_layout);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.news:
                        Toast.makeText(NewsActivity.this, "新闻", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.photos:
                        Toast.makeText(NewsActivity.this, "图片", Toast.LENGTH_LONG).show();
                        break;
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showErrMessage() {

    }
}
