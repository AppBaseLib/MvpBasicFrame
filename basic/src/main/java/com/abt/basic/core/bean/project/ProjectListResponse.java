package com.abt.basic.core.bean.project;


import com.abt.basic.core.bean.BaseResponse;

/**
 * @描述： @ProjectListResponse
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public class ProjectListResponse extends BaseResponse {

    private ProjectListData data;

    public ProjectListData getData() {
        return data;
    }

    public void setData(ProjectListData data) {
        this.data = data;
    }
}
