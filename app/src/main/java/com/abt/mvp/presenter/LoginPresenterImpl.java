
package com.abt.mvp.presenter;

import com.abt.mvp.model.ILoginModel;
import com.abt.mvp.model.LoginModelImpl;
import com.abt.mvp.view.ILoginView;

public class LoginPresenterImpl implements ILoginPresenter, ILoginModel.OnLoginFinishedListener {

    private ILoginView loginView;
    private ILoginModel loginModel;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginModel.login(username, password, this);
    }

    @Override public void onDestroy() {
        loginView = null;
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

    @Override public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}
