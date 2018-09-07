package com.abt.basic.arch.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.abt.basic.arch.mvp.presenter.AbstractPresenter;
import com.abt.basic.arch.mvp.view.AbstractView;

/**
 * @描述： @MVP模式的BaseFragment
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public abstract class BaseFragment<T extends AbstractPresenter> extends AbstractSimpleFragment implements AbstractView {

    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
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


