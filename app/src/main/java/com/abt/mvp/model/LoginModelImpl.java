package com.abt.mvp.model;

import android.os.Handler;
import android.text.TextUtils;

public class LoginModelImpl implements ILoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    error = true;
                }
                if (!error) {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
