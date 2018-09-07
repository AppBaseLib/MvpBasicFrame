
package com.abt.mvp.model;

/**
 * @author 黄卫旗
 * @description ILoginModel
 * @time 2018/09/07
 */
public interface ILoginModel {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
