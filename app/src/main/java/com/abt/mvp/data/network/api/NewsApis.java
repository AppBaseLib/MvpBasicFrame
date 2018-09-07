package com.abt.mvp.data.network.api;

import android.database.Observable;

import com.abt.mvp.app.URLConstant;
import com.abt.mvp.data.bean.news.NewsBean;

import retrofit2.http.GET;

/**
 * @描述： @NewsApis
 * @作者： @黄卫旗
 * @创建时间： @20/05/2018
 */
public interface NewsApis {

    //获取“分类中搜索商品”的数据
    @GET(URLConstant.URL_PATH)
    Observable<NewsBean> getNewsData();
}
