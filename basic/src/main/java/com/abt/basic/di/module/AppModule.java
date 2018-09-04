package com.abt.basic.di.module;

import com.abt.basic.app.BaseApp;
import com.abt.basic.core.DataManager;
import com.abt.basic.core.db.DbHelper;
import com.abt.basic.core.db.GreenDaoHelper;
import com.abt.basic.core.http.HttpHelper;
import com.abt.basic.core.http.RetrofitHelper;
import com.abt.basic.core.prefs.PreferenceHelper;
import com.abt.basic.core.prefs.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @描述： @AppModule
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
@Module
public class AppModule {

    private final BaseApp application;

    public AppModule(BaseApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    BaseApp provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DbHelper provideDBHelper(GreenDaoHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(PreferenceHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbhelper, PreferenceHelper preferencesHelper) {
        return new DataManager(httpHelper, dbhelper, preferencesHelper);
    }

}
