package com.abt.mvp.di.component;

import com.abt.basic.app.BaseApp;
import com.abt.mvp.di.module.AppModule;
import com.abt.mvp.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @描述： @AppComponent
 * @作者： @黄卫旗
 * @创建时间： @08/09/2018
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    BaseApp getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    //DataManager getDataManager();

    /**
     * 提供http的帮助类
     *
     * @return RetrofitHelper
     */
    //HttpHelper httpHelper();

    /**
     * 提供数据库帮助类
     *
     * @return GreenDaoHelper
     */
    //DbHelper realmHelper();

    /**
     * 提供sp帮助类
     *
     * @return PreferenceHelperImpl
     */
    //PreferenceHelperImpl preferencesHelper();

}
