package com.abt.basic.arch.mvp.view.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.abt.basic.arch.component.ActivityCollector;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * @描述： @AbstractSimpleActivity
 * @作者： @黄卫旗
 * @创建时间： @05/06/2018
 */
public abstract class AbstractSimpleActivity extends SupportActivity {

    private Unbinder unBinder;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        onViewCreated();
        ActivityCollector.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        unBinder.unbind();
    }

    protected void onViewCreated() {

    }

    /**
     * 获取当前Activity的UI布局
     * @return 布局id
     */
    protected abstract int getLayoutId();

}
