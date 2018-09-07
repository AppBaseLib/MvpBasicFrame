package com.abt.basic.arch.mvp.model;

/**
 * @描述： @AbstractModel
 * @作者： @黄卫旗
 * @创建时间： @2018/5/29
 */
public interface AbstractModel<T> {

    void getData(LoadCallback<T> callback);
}
