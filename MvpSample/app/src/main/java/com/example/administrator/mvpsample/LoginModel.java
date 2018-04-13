package com.example.administrator.mvpsample;


import android.os.Handler;

import com.example.mvplib.callback.CallBack;

/**
 * Author:liuzj
 * Time:2018/3/7
 * Description:M层
 */

public class LoginModel {

    public void Login(final CallBack<String> callBack) {
        //模拟网络环境
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callBack.onResponse("你好！欢迎您");
            }
        },500);

    }
}
