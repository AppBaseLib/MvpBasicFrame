package com.abt.basic.arch.mvp.presenter;

import com.abt.basic.arch.mvp.view.AbstractView;

/**
 * @描述： @BasePresenter
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public class BasePresenter<T extends AbstractView> implements AbstractPresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

}

