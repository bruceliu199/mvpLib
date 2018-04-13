package com.example.mvplib.callback;

/**
 * Author:liuzj
 * Time:2018/3/7
 * Description: 数据回调接口
 */

public interface CallBack<T> {

    void onResponse(T response);
    void onFailure(String error);
}
