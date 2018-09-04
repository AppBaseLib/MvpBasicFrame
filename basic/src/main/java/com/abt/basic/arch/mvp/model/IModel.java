package com.abt.basic.arch.mvp.model;

import com.abt.basic.arch.mvp.view.load.BaseLoadListener;

/**
 * @描述： @IModel
 * @作者： @黄卫旗
 * @创建时间： @2018/5/29
 */
public interface IModel<T> {

    void getData(BaseLoadListener<T> listener);
}
