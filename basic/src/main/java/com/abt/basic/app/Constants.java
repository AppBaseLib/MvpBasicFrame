package com.abt.basic.app;

import android.graphics.Color;

import java.io.File;

/**
 * @描述： @Constants
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public class Constants {

    /**
     * Path
     */
    private static final String PATH_DATA = BaseApp.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    /**
     * Tab colors
     */
    public static final int[] TAB_COLORS = new int[]{
            Color.parseColor("#90C5F0"),
            Color.parseColor("#91CED5"),
            Color.parseColor("#F88F55"),
            Color.parseColor("#C0AFD0"),
            Color.parseColor("#E78F8F"),
            Color.parseColor("#67CCB7"),
            Color.parseColor("#F6BC7E")
    };

    /**
     * Shared Preference key
     */
    public static final String ACCOUNT = "account";
    public static final String PASSWORD = "password";
    public static final String LOGIN_STATUS = "login_status";
    public static final String DB_NAME = "aws_wan_android.db";
    public static final String CURRENT_PAGE = "current_page";
    public static final String PROJECT_CURRENT_PAGE = "project_current_page";


}
