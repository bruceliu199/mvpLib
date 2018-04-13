package com.example.mvplib.mvp.base;

import android.os.Bundle;

/**
 * 创建时间：2018/3/8
 * 创建人： liuzj
 * 描述： 所有Presenter的基类，并不强制实现这些方法，有需要再重写
 * 包名：com.ego.main.mvp.base
 * 邮箱：liuzj@hi-board.com
 */
//指定绑定的view都要继承自IBaseMvpView
public class BaseMvpPresenter<V extends IBaseMvpView> {
//presenter也需要根据view的生命来释放资源，保存数据等，所以这里增加生命周期方法
    private V view;

    /**
     * 创建presenter时调用
     * @param savedState
     */
    public void onCreatePresenter(Bundle savedState) {

    }

    /**
     * 绑定V层
     * @param view
     */
    public void onAttachView(V view) {
        this.view = view;
    }

    /**
     * 与V层解绑
     */
    public void onDetachView() {
        this.view = null;
    }

    /**
     * presenter被销毁时调用
     */
    public void onDestoryPresenter() {

    }

    /**
     * 在Presenter意外销毁的时候被调用，它的调用时机和Activity、Fragment、View中的onSaveInstanceState时机相同
     *
     * @param outState
     */
    public void onSaveInstanceState(Bundle outState) {

    }

    /**
     * 提供一个获取view的方法，后面的子类可通过此方法获取V层
     * @return
     */
    public V getView() {
        return this.view;
    }

}
