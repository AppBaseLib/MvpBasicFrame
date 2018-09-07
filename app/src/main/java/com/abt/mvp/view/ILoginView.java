
package com.abt.mvp.view;

/**
 * @author 黄卫旗
 * @description ILoginView
 * @time 2018/09/07
 */
public interface ILoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
