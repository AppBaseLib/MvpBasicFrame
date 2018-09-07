package com.abt.mvp.contract;

import com.abt.basic.arch.mvp.presenter.AbstractPresenter;
import com.abt.basic.arch.mvp.view.AbstractView;

/**
 * @描述： @LoginContract
 * @作者： @黄卫旗
 * @创建时间： @07/09/2018
 */
public interface LoginContract {

    interface View extends AbstractView {
        /**
         * Show login data
         */
        void showLoginSuccess();

        void showProgress();

        void hideProgress();

        void setUsernameError();

        void setPasswordError();

        void navigateToHome();
    }

    interface Presenter extends AbstractPresenter<View> {
        /**
         * Set login status
         * @param account account
         */
        void setLoginAccount(String account);

        /**
         * Set login password
         * @param password password
         */
        void setLoginPassword(String password);

        /**
         * Get Login data
         * @param username user name
         * @param password password
         */
        void getLoginData(String username, String password);
    }

}
