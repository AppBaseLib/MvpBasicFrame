package com.abt.basic.di.module;

import android.app.Activity;

import com.abt.basic.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @描述： @ActivityModule
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }

}
