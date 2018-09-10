package com.abt.mvp.view.live;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.abt.basic.logger.LogHelper;

/**
 * @描述： @LiveActivity
 * @作者： @黄卫旗
 * @创建时间： @10/09/2018
 */
public class LiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(new MyObserver());
    }

    public static class MyObserver implements LifecycleObserver {
        private static final String TAG = MyObserver.class.getSimpleName();
        @OnLifecycleEvent(android.arch.lifecycle.Lifecycle.Event.ON_RESUME)
        public void onResume() {
            LogHelper.d(TAG, "onResume");
        }

        @OnLifecycleEvent(android.arch.lifecycle.Lifecycle.Event.ON_PAUSE)
        public void onPause() {
            LogHelper.d(TAG, "onPause");
        }
    }

}
