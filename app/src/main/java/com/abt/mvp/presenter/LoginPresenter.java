
package com.abt.mvp.presenter;

import android.text.TextUtils;

import com.abt.basic.logger.LogHelper;
import com.abt.mvp.contract.LoginContract;
import com.abt.mvp.data.bean.main.login.LoginData;
import com.abt.mvp.model.ILoginModel;
import com.abt.mvp.model.LoginModel;

import java.util.List;

/**
 * @author 黄卫旗
 * @description LoginPresenter
 * @time 2018/09/07
 */
public class LoginPresenter implements LoginContract.Presenter, ILoginModel.OnLoginCallback {

    private static final String TAG = LoginPresenter.class.getSimpleName();
    private LoginContract.View loginView;
    private ILoginModel loginModel;

    public LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModel();
    }

    @Override public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void attachView(LoginContract.View view) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void setLoginAccount(String account) {

    }

    @Override
    public void setLoginPassword(String password) {

    }

    @Override
    public void getLoginData(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            loginView.hideProgress();
            loginView.setUsernameError();
            return;

        }
        if (TextUtils.isEmpty(password)) {
            loginView.setPasswordError();
            loginView.setPasswordError();
            return;
        }
        loginView.showProgress();
        loginModel.login(username, password, this);
    }

    @Override
    public void loadSuccess(List<LoginData> list) {
        LoginData bean = list.get(0);
        if (!TextUtils.isEmpty(bean.getUsername())) {
            loginView.showLoginSuccess();
        }
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }

    @Override
    public void loadFailure(String message) {
        LogHelper.d(TAG, "loadFailure");
    }

    @Override
    public void loadStart() {
        //loginModel.getData(this);
    }

    @Override
    public void loadComplete() {

    }
}
