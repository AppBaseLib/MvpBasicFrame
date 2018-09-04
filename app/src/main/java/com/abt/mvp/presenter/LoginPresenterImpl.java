/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */
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
