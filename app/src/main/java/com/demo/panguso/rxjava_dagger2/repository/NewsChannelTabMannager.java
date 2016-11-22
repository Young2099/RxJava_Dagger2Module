package com.demo.panguso.rxjava_dagger2.repository;

import com.demo.panguso.rxjava_dagger2.R;
import com.demo.panguso.rxjava_dagger2.app.App;
import com.demo.panguso.rxjava_dagger2.common.ApiConstants;
import com.demo.panguso.rxjava_dagger2.utils.SharedPreferencesUtil;

import java.util.Arrays;
import java.util.List;

import de.greenrobot.dao.query.Query;
import greendao.NewsChannelTable;
import greendao.NewsChannelTableDao;

/**
 * Created by ${yangfang} on 2016/11/17.
 */

public class NewsChannelTabMannager {


    /**
     * 首次打开程序初始化db数据库，加载频道数据
     */
    public static void initDB() {
        if (!SharedPreferencesUtil.getChannelData()) {
            NewsChannelTableDao dao = App.getNewsChannelTableDao();
            //获取到本地的数据信息，将其插入到数据库，这里使用的是GreenDao
            List<String> channelName = Arrays.asList(App.getAppContext().getResources()
                    .getStringArray(R.array.news_channel_name));
            List<String> channelId = Arrays.asList(App.getAppContext()
                    .getResources().getStringArray(R.array.news_channel_id));
            for (int i = 0; i < channelName.size(); i++) {
                NewsChannelTable entity = new NewsChannelTable(channelName.get(i), channelId.get(i)
                        , ApiConstants.getType(channelId.get(i)), i <= 2, i, i == 0);
                dao.insert(entity);
            }
            SharedPreferencesUtil.saveChannelData(true);
        }
    }

    /**
     * 查询我添加的频道
     *
     * @return
     */
    public static List<NewsChannelTable> loadNewsChannelsMine() {
        Query<NewsChannelTable> newsChannelTableQueryBuilder = App.getNewsChannelTableDao()
                .queryBuilder().where(NewsChannelTableDao.Properties.NewsChannelSelect.eq(true))
                .orderAsc(NewsChannelTableDao.Properties.NewsChannelIndex).build();
        return newsChannelTableQueryBuilder.list();
    }
}
