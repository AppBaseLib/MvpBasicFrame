package com.abt.basic.app;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.abt.basic.core.dao.DaoMaster;
import com.abt.basic.core.dao.DaoSession;
import com.abt.basic.di.component.AppComponent;
import com.squareup.leakcanary.RefWatcher;

/**
 * @描述： @BaseApp
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public abstract class BaseApp extends Application {

    private DaoSession mDaoSession;
    private static BaseApp sContext;    
    private RefWatcher refWatcher;
    private static volatile AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        init();
        initComplete();
        initGreenDao();        
    }

    public static final BaseApplication getAppContext() {
        return sContext;
    }

    private final void init() {
        if (BuildConfig.DEBUG) {
            //DebugManage.initialize(this);
        }
    }

    public abstract void initComplete();

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, Constants.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }

    public static synchronized AppComponent getAppComponent() {
        if (appComponent == null) {
            //TODO
            /*appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();*/
        }
        return appComponent;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static RefWatcher getRefWatcher(Context context) {
        BaseApp application = (BaseApp) context.getApplicationContext();
        return application.refWatcher;
    }

}
