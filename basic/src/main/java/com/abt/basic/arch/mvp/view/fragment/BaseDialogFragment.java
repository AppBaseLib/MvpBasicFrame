package com.abt.basic.arch.mvp.view.fragment;

import android.os.Bundle;

import com.abt.basic.arch.mvp.presenter.AbstractPresenter;
import com.abt.basic.arch.mvp.view.AbstractView;

/**
 * @描述： @MVP模式的Base Dialog fragment
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public abstract class BaseDialogFragment<T extends AbstractPresenter> extends AbstractSimpleDialogFragment implements AbstractView {

    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    @Override
    public void showLoading() {

    }

}

