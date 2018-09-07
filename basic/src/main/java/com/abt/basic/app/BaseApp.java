package com.abt.basic.app;

import android.app.Application;

import com.abt.basic.BuildConfig;

/**
 * @描述： @BaseApp
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public abstract class BaseApp extends Application {

    private static BaseApp sContext;

    public static final BaseApp getAppContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        initial();
        initComplete();
    }

    public abstract void initComplete();

    private final void initial() {
        if (BuildConfig.DEBUG) {
            //DebugManage.initialize(this);
        }
    }

}
