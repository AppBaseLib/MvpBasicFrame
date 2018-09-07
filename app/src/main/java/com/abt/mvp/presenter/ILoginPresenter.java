
package com.abt.mvp.presenter;

public interface ILoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
