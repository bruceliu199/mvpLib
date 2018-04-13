package com.example.administrator.mvpsample;

import android.os.Handler;

import com.example.mvplib.callback.CallBack;

/**
 * DATE：2018/4/13
 * USER： liuzj
 * DESC：
 * email：liuzj@hi-board.com
 */

public class LoginModel2 {

    public void Login(final CallBack<String> callBack) {
        //模拟网络请求
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callBack.onResponse("你好！我是网络数据");
            }
        },500);

    }
}
