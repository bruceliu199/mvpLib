package com.example.administrator.mvpsample;

import android.os.Handler;

import com.example.mvplib.callback.CallBack;
import com.example.mvplib.mvp.base.BaseMvpPresenter;

/**
 * DATE：2018/4/13
 * USER： liuzj
 * DESC：
 * email：liuzj@hi-board.com
 */

public class LoginPresenter2 extends BaseMvpPresenter<LoginView2> {

    private LoginModel2 model;

    public LoginPresenter2() {
        this.model = new LoginModel2();
    }

    public void doLogin() {
        /*
        * 在P层刷新UI
        * */
        getView().showLoading(false);
        model.Login(new CallBack<String>() {
            @Override
            public void onResponse(String response) {
                getView().bindData(response);
                getView().showContent(false);
            }

            @Override
            public void onFailure(String error) {
                getView().showError();
            }
        });
    }
}
