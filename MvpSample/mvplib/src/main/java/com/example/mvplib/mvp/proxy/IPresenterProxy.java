package com.example.mvplib.mvp.proxy;


import com.example.mvplib.mvp.base.BaseMvpPresenter;
import com.example.mvplib.mvp.base.IBaseMvpView;
import com.example.mvplib.mvp.factory.IPresenterFactory;

/**
 * 创建时间：2018/3/8
 * 创建人： liuzj
 * 描述：
 * 包名：com.ego.main.mvp.proxy
 * 邮箱：liuzj@hi-board.com
 */
//提供代理接口给V层使用 交给V层实现
public interface IPresenterProxy<V extends IBaseMvpView, P extends BaseMvpPresenter<V>> {

    /**
     * 设置presenter创建工厂
     * @param factory
     */
    void setPresenterFactory(IPresenterFactory<V, P> factory);

    IPresenterFactory<V, P> getPresenterFactory();

    /**
     * 获取创建的presenter
     * @return
     */
    P getPresenter();

}
