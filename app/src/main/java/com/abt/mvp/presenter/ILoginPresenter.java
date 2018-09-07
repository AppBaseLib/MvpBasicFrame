
package com.abt.mvp.presenter;

/**
 * @author 黄卫旗
 * @description ILoginPresenter
 * @time 2018/09/07
 */
public interface ILoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
