package com.abt.basic.arch.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

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
    protected AbstractSimpleActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        mActivity = this;
        onViewCreated();
        ActivityCollector.getInstance().addActivity(this);
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        unBinder.unbind();
    }

    protected void setToolBar(Toolbar toolBar, CharSequence title) {
        toolBar.setTitle(title);
        setSupportActionBar(toolBar);
        assert getSupportActionBar() != null;
    }

    protected void onViewCreated() {

    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();

}
