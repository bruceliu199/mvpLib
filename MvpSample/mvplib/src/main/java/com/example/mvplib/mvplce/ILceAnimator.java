package com.example.mvplib.mvplce;

import android.view.View;

/**
 * 创建时间：2018/3/8
 * 创建人： liuzj
 * 描述：
 * 包名：com.ego.main.mvplce
 * 邮箱：liuzj@hi-board.com
 */
//定义动画接口 策略模式
public interface ILceAnimator {

    void showLoading(View loadingView, View contentView, View errorView);

    void showErrorView(View loadingView, View contentView, View errorView);

    void showContent(View loadingView, View contentView, View errorView);
}
