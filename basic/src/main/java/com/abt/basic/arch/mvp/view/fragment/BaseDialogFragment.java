package com.abt.basic.arch.mvp.view.fragment;

import android.os.Bundle;

import com.abt.basic.R;
import com.abt.basic.arch.mvp.presenter.AbstractPresenter;
import com.abt.basic.utils.CommonUtil;
import com.abt.basic.arch.mvp.view.IBaseView;

import javax.inject.Inject;

/**
 * @描述： @MVP模式的Base Dialog fragment
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public abstract class BaseDialogFragment<T extends AbstractPresenter> extends AbstractSimpleDialogFragment implements IBaseView {

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

