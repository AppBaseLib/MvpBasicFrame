package com.abt.basic.core.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @描述： @HistoryData
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
@Entity
public class HistoryData {

    private long date;
    private String data;

    @Generated(hash = 1452354993)
    public HistoryData(long date, String data) {
        this.date = date;
        this.data = data;
    }

    @Generated(hash = 422767273)
    public HistoryData() {
    }
    
    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
