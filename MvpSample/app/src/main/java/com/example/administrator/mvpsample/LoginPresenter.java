package com.example.administrator.mvpsample;

import com.example.mvplib.callback.CallBack;
import com.example.mvplib.mvp.base.BaseMvpPresenter;


/**
 * Author:liuzj
 * Time:2018/3/7
 * Description:
 */

public class LoginPresenter extends BaseMvpPresenter<LoginView> {
    /*P层要持有M层和V层的引用*/
    private LoginModel model;

    public LoginPresenter() {
        this.model = new LoginModel();
    }

    public void doLogin() {
        /*
        * 在P层刷新UI
        * */

        if (getView() != null) getView().showLoading();

        model.Login(new CallBack<String>() {
            @Override
            public void onResponse(String response) {
                if (getView() != null) getView().onSuccess(response);
            }

            @Override
            public void onFailure(String error) {
                if (getView() != null) getView().onFaile(error);
            }
        });
    }

    /**
     * 这里可以用于做网络请求的取消操作
     */
    @Override
    public void onDestoryPresenter() {
        super.onDestoryPresenter();
        //值得注意的是，如果你真的有用网络请求，这里最好要做一个网络请求的取消操作
    }
}
