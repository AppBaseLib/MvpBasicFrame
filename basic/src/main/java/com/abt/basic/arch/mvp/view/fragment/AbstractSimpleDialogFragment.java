package com.abt.basic.arch.mvp.view.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abt.basic.app.BaseApp;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @描述： @Common simple dialog fragment
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public abstract class AbstractSimpleDialogFragment extends DialogFragment {

    private Unbinder unBinder;
    public View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, mRootView);
        initData();
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unBinder.unbind();
    }

    /**
     * 获取当前Activity的UI布局
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initData();

}

