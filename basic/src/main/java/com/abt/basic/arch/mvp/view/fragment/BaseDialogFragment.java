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

    @Inject
    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
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

    // TODO
    /*public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(BaseApp.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }*/

    @Override
    public void showErrorMsg(String errorMsg) {
        if (getActivity() != null) {
            CommonUtil.showSnackMessage(getActivity(), errorMsg);
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showCollectFail() {
        if (getActivity() != null) {
            CommonUtil.showSnackMessage(getActivity(), getString(R.string.collect_fail));
        }
    }

    @Override
    public void showCancelCollectFail() {
        if (getActivity() != null) {
            CommonUtil.showSnackMessage(getActivity(), getString(R.string.cancel_collect_fail));
        }
    }

    @Override
    public void showCollectSuccess() {

    }

    @Override
    public void showCancelCollectSuccess() {

    }

    @Override
    public void showLoginView() {

    }

    @Override
    public void showLogoutView() {

    }

    /**
     * 注入当前Fragment所需的依赖
     */
    protected abstract void initInject();

}
