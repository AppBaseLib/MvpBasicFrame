package com.abt.mvp.model;

import com.abt.basic.arch.mvp.model.LoadCallback;
import com.abt.mvp.app.MvpApplication;
import com.abt.mvp.data.bean.main.login.LoginData;
import com.abt.mvp.data.network.HttpHelper;

/**
 * @author 黄卫旗
 * @description LoginModel
 * @time 2018/09/07
 */
public class LoginModel implements ILoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginCallback callback) {
        HttpHelper httpHelper = MvpApplication.getInstance().getDataManager();
        httpHelper.login(username, password);
        //httpHelper.getLoginData(username, password);
    }

    @Override
    public void getData(LoadCallback<LoginData> callback) {

    }

    private void handleCallback() {
        /* new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)) {
                    callback.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)) {
                    callback.onPasswordError();
                    error = true;
                }
                List<LoginData> list = new ArrayList<>();
                list.add(new LoginData());
                if (!error) {
                    callback.loadSuccess(list);
                }
            }
        }, 2000);*/
    }
}
