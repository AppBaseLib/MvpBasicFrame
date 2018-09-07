
package com.abt.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.abt.basic.arch.mvp.view.activity.BaseActivity;
import com.abt.basic.logger.LogHelper;
import com.abt.basic.utils.ToastUtil;
import com.abt.mvp.R;
import com.abt.mvp.contract.LoginContract;
import com.abt.mvp.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author 黄卫旗
 * @description LoginActivity
 * @time 2018/09/07
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;

    LoginContract.Presenter mPresenter;

    @OnClick(R.id.button) void login(Button button) {
        LogHelper.d(TAG, "click to login()");
        ToastUtil.show("click to login()");
        button.setText(R.string.logined);
        mPresenter.getLoginData(username.getText().toString(), password.getText().toString());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogHelper.d(TAG, "onCreate()");
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public void showLoginSuccess() {
        ToastUtil.show("login success!!");
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override public void navigateToHome() {
        MainActivity.startActivity();
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }
}
