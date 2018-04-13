package com.example.administrator.mvpsample;


import com.example.mvplib.mvp.base.IBaseMvpView;

/**
 * Author:liuzj
 * Time:2018/3/7
 * Description: V层接口
 */

public interface LoginView extends IBaseMvpView {
    /**
     * 展示加载过程
     */
    void showLoading();
    void onSuccess(String response);
    void onFaile(String error);
}
