package com.abt.mvp.data.db;

import com.abt.mvp.data.dao.HistoryData;

import java.util.List;


/**
 * @描述： @DbHelper
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public interface DbHelper {

    /**
     * 增加历史数据
     *
     * @param data  added string
     * @return  List<HistoryData>
     */
    List<HistoryData> addHistoryData(String data);

    /**
     * Clear search history data
     */
    void clearHistoryData();

}
