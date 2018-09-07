package com.abt.basic.arch.mvp.view.activity;

import com.abt.basic.R;
import com.abt.basic.arch.mvp.presenter.AbstractPresenter;
import com.abt.basic.utils.CommonUtil;
import com.abt.basic.arch.mvp.view.IBaseView;

import javax.inject.Inject;

/**
 * @描述： @MVP模式的BaseActivity
 * @作者： @黄卫旗
 * @创建时间： @05/06/2018
 */
public abstract class BaseActivity<T extends AbstractPresenter> extends AbstractSimpleActivity implements IBaseView {

    protected T mPresenter;

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {

    }

}
