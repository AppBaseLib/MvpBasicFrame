
package com.abt.mvp.model;

import com.abt.basic.arch.mvp.model.AbstractModel;
import com.abt.basic.arch.mvp.model.LoadCallback;
import com.abt.mvp.data.bean.main.login.LoginData;

/**
 * @author 黄卫旗
 * @description ILoginModel
 * @time 2018/09/07
 */
public interface ILoginModel extends AbstractModel<LoginData> {

    void login(String username, String password, OnLoginCallback callback);

    interface OnLoginCallback extends LoadCallback<LoginData> {
        void onUsernameError();
        void onPasswordError();
    }

}
