package com.abt.mvp.data.network.retorfit;

import android.database.Observable;

import com.abt.mvp.app.URLConstant;
import com.abt.mvp.data.bean.news.NewsBean;
import com.abt.mvp.data.network.api.NewsApis;
import com.abt.mvp.data.network.api.WebApis;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @描述： @RetrofitHelper
 * @作者： @黄卫旗
 * @创建时间： @20/05/2018
 */
public class RetrofitHelper {

    private static final int DEFAULT_TIMEOUT = 8; //连接 超时的时间，单位：秒
    private static RetrofitHelper httpUtils;
    private static Retrofit retrofit;
    private static WebApis retrofitInterface;
    private static final OkHttpClient client = new OkHttpClient.Builder().
            connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).
            readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).
            writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();

    private synchronized static NewsApis getRetrofit() {
        //初始化retrofit的配置
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URLConstant.URL_BASE)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            retrofitInterface = retrofit.create(WebApis.class);
        }
        return (NewsApis) retrofitInterface;
    }

    //获取新闻数据
    public static Observable<NewsBean> getNewsData() {
        return getRetrofit().getNewsData();
    }

}
