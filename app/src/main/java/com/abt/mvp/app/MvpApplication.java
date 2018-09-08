package com.abt.mvp.app;

import android.database.sqlite.SQLiteDatabase;

import com.abt.basic.app.BaseApp;
import com.abt.basic.app.Constants;
import com.abt.mvp.data.DataManager;
import com.abt.mvp.data.account.FilePrefsHelper;
import com.abt.mvp.data.account.FilePrefsImpl;
import com.abt.mvp.data.dao.DaoMaster;
import com.abt.mvp.data.dao.DaoSession;
import com.abt.mvp.data.db.DbHelper;
import com.abt.mvp.data.db.DbHelperImpl;
import com.abt.mvp.data.file.FileHelper;
import com.abt.mvp.data.file.FileHelperImpl;
import com.abt.mvp.data.network.HttpHelper;
import com.abt.mvp.data.network.HttpHelperImpl;
import com.abt.mvp.data.network.api.GeeksApis;
import com.abt.mvp.data.prefs.PreferenceHelper;
import com.abt.mvp.data.prefs.PreferenceHelperImpl;
import com.abt.mvp.di.component.AppComponent;
import com.squareup.leakcanary.RefWatcher;

/**
 * @描述： @MvpApplication
 * @作者： @黄卫旗
 * @创建时间： @05/09/2018
 */
public class MvpApplication extends BaseApp {

    private static MvpApplication mInstance;
    private DataManager mDataManager;
    private GeeksApis mGeeksApis;
    private DaoSession mDaoSession;
    private static RefWatcher refWatcher;
    private static volatile AppComponent appComponent;

    public static MvpApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    @Override
    public void initComplete() {
        initApis();
        initGreenDao();
        initDataManager();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(
                this, Constants.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }

    private void initApis() {
        mGeeksApis = (GeeksApis) new HttpHelperImpl();
    }

    private void initDataManager() {
        HttpHelper httpHelper = new HttpHelperImpl();
        DbHelper dbHelper = new DbHelperImpl();
        FileHelper fileHelper = new FileHelperImpl();
        PreferenceHelper preferenceHelper = new PreferenceHelperImpl();
        FilePrefsHelper filePrefsHelper = new FilePrefsImpl();
        mDataManager = new DataManager(httpHelper, dbHelper, fileHelper, preferenceHelper, filePrefsHelper);
    }

    public static synchronized AppComponent getAppComponent() {
        if (appComponent == null) {
            /*appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();*/
        }
        return appComponent;
    }

    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public GeeksApis getGeeksApis() {
        return mGeeksApis;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

}
