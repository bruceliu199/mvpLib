package com.example.mvplib.mvp.factory;


import com.example.mvplib.mvp.base.BaseMvpPresenter;
import com.example.mvplib.mvp.base.IBaseMvpView;

/**
 * 创建时间：2018/3/8
 * 创建人： liuzj
 * 描述：
 * 包名：com.ego.main.mvp.factory
 * 邮箱：liuzj@hi-board.com
 */
//presenter工厂接口 指定View和Presenter只能继承自IBaseMvpView和BaseMvpPresenter
public interface IPresenterFactory<V extends IBaseMvpView, P extends BaseMvpPresenter<V>> {

    /**
     * 创建presenter的方法
     * @return
     */
    P createPresenter();
}
