package com.example.mvplib.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.mvplib.mvp.base.BaseMvpPresenter;
import com.example.mvplib.mvp.base.IBaseMvpView;
import com.example.mvplib.mvp.factory.IPresenterFactory;
import com.example.mvplib.mvp.factory.PresenterFactoryImpl;
import com.example.mvplib.mvp.proxy.BaseMvpPresenterProxyImpl;
import com.example.mvplib.mvp.proxy.IPresenterProxy;


/**
 * 创建时间：2018/3/8
 * 创建人： liuzj
 * 描述：
 * 包名：com.ego.main.mvp
 * 邮箱：liuzj@hi-board.com
 */
//使用代理模式来代理Presenter的创建、销毁、绑定、解绑以及Presenter的状态保存,其实就是管理Presenter的生命周期
public abstract class BaseMvpFragment<V extends IBaseMvpView, P extends BaseMvpPresenter<V>>
        extends Fragment implements IPresenterProxy<V, P> {
    // 根据V层的生命周期用presenter代理来管理presenter的生命周期
    private static final String KEY_SAVE_PRESENTER = "key_save_presenter";
    /**
     * 创建被代理对象,传入默认Presenter的工厂
     */
    private BaseMvpPresenterProxyImpl<V, P> presenterProxy = new BaseMvpPresenterProxyImpl<>(PresenterFactoryImpl.<V, P>createFactory(getClass()));

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            //重新创建时获取之前保存的Bundle
            presenterProxy.onRestoreInstanceState(savedInstanceState.getBundle(KEY_SAVE_PRESENTER));
        }
        presenterProxy.onAttachView((V) this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterProxy.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //存入这个Bundle
        outState.putBundle(KEY_SAVE_PRESENTER, presenterProxy.onSaveInstanceState());
    }

    @Override
    public void setPresenterFactory(IPresenterFactory<V, P> factory) {
        presenterProxy.setPresenterFactory(factory);
    }

    @Override
    public IPresenterFactory<V, P> getPresenterFactory() {
        return presenterProxy.getPresenterFactory();
    }

    @Override
    public P getPresenter() {
        return presenterProxy.getPresenter();
    }
}
