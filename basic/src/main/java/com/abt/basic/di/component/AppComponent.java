package com.abt.basic.di.component;

import com.abt.basic.app.BaseApp;
import com.abt.basic.core.DataManager;
import com.abt.basic.core.db.GreenDaoHelper;
import com.abt.basic.core.http.RetrofitHelper;
import com.abt.basic.core.prefs.PreferenceHelperImpl;
import com.abt.basic.di.module.AppModule;
import com.abt.basic.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author quchao
 * @date 2017/11/27
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
    DataManager getDataManager();

    /**
     * 提供http的帮助类
     *
     * @return RetrofitHelper
     */
    RetrofitHelper retrofitHelper();

    /**
     * 提供数据库帮助类
     *
     * @return GreenDaoHelper
     */
    GreenDaoHelper realmHelper();

    /**
     * 提供sp帮助类
     *
     * @return PreferenceHelperImpl
     */
    PreferenceHelperImpl preferencesHelper();

}
