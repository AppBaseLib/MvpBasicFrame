package com.abt.mvp.view.live;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.abt.basic.logger.LogHelper;

/**
 * @描述： @LifeCycleActivity
 * @作者： @黄卫旗
 * @创建时间： @10/09/2018
 */
public class LifeCycleActivity extends AppCompatActivity implements LifecycleRegistryOwner {

    private MyLocationListener myLocationListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myLocationListener = new MyLocationListener(this, getLifecycle());
        getLifecycle().addObserver(myLocationListener);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    class MyLocationListener implements LifecycleObserver {

        private final String TAG = MyLocationListener.class.getSimpleName();
        private boolean enabled = false;
        Lifecycle lifecycle = null;

        public MyLocationListener(Context context, final Lifecycle lifecycle) {
            this.lifecycle = lifecycle;
            LogHelper.d(TAG, "MyLocationListener");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        void start() {
            LogHelper.d(TAG, "start");
            if (enabled) {
                // connect
            }
        }

        public void enable() {
            LogHelper.d(TAG, "enable");
            enabled = true;
            //⓵
            /*if (lifecycle.getState().isAtLeast(STARTED)) {
                // connect if not connected
            }*/
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        void stop() {
            LogHelper.d(TAG, "stop");
            // disconnect if connected
        }
    }

}
