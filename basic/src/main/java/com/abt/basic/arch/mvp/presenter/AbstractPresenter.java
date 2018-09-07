package com.abt.basic.arch.mvp.presenter;

import com.abt.basic.arch.mvp.view.IBaseView;

/**
 * @描述： @Presenter基类
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public interface AbstractPresenter<T extends IBaseView> {
    /**
     * 注入View
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();

}
