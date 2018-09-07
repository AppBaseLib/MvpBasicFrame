package com.abt.basic.arch.mvp.model;

import java.util.List;

/**
 * @描述： @LoadCallback
 * @作者： @黄卫旗
 * @创建时间： @20/05/2018
 */
public interface LoadCallback<T> {
    /**
     * 开始加载
     */
    void loadStart();
    /**
     * 加载结束
     */
    void loadComplete();
    /**
     * 加载数据成功
     * @param list
     */
    void loadSuccess(List<T> list);
    /**
     * 加载失败
     * @param message
     */
    void loadFailure(String message);
}
