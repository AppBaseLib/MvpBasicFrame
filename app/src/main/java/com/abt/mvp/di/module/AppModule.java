package com.abt.mvp.di.module;

import com.abt.basic.app.BaseApp;
import com.abt.mvp.data.DataManager;
import com.abt.mvp.data.account.FilePrefsHelper;
import com.abt.mvp.data.db.DbHelper;
import com.abt.mvp.data.file.FileHelper;
import com.abt.mvp.data.network.HttpHelper;
import com.abt.mvp.data.prefs.PreferenceHelper;
import com.abt.mvp.data.prefs.PreferenceHelperImpl;

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
    HttpHelper provideHttpHelper(HttpHelper httpHelper) {
        return httpHelper;
    }

    @Provides
    @Singleton
    DbHelper provideDBHelper(DbHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(PreferenceHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbHelper, FileHelper fileHelper,
                                   PreferenceHelper preferenceHelper, FilePrefsHelper prefsHelper) {
        return new DataManager(httpHelper, dbHelper, fileHelper,
                preferenceHelper, prefsHelper);
    }

}
