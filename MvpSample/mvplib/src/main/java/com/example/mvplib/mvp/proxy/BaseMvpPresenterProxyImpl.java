package com.example.mvplib.mvp.proxy;

import android.os.Bundle;

import com.example.mvplib.mvp.base.BaseMvpPresenter;
import com.example.mvplib.mvp.base.IBaseMvpView;
import com.example.mvplib.mvp.factory.IPresenterFactory;


/**
 * 创建时间：2018/3/8
 * 创建人： liuzj
 * 描述：presenter代理  实现代理接口
 * 包名：com.ego.main.mvp.proxy
 * 邮箱：liuzj@hi-board.com
 */
//presenter代理的实现类  用来管理生命周期和view之间的关联
public class BaseMvpPresenterProxyImpl<V extends IBaseMvpView, P extends BaseMvpPresenter<V>> implements IPresenterProxy<V, P> {
    /**
     * 获取onSaveInstanceState中bundle的key
     */
    private static final String PRESENTER_KEY = "presenter_key";
    /**
     * Presenter工厂类
     */
    private IPresenterFactory<V, P> mFactory;
    private P mPresenter;
    private Bundle mBundle;
    private boolean mIsAttchView;

    public BaseMvpPresenterProxyImpl(IPresenterFactory<V, P> mFactory) {
        this.mFactory = mFactory;
    }

    @Override
    public void setPresenterFactory(IPresenterFactory<V, P> factory) {
        if (mPresenter != null) {
            throw new IllegalArgumentException("这个方法只能在getPresenter()之前调用，如果Presenter已经创建则不能再修改");
        }
        this.mFactory = factory;
    }

    @Override
    public IPresenterFactory<V, P> getPresenterFactory() {
        return this.mFactory;
    }

    @Override
    public P getPresenter() {
        if (mFactory != null) {
            if (mPresenter == null) {
                mPresenter = mFactory.createPresenter();
                mPresenter.onCreatePresenter(mBundle == null ? null : mBundle.getBundle(PRESENTER_KEY));
            }
        }

        return mPresenter;
    }

    /**
     * 绑定Presenter和view
     *
     * @param mvpView
     */
    public void onAttachView(V mvpView) {
        if (getPresenter() != null && !mIsAttchView) {
            getPresenter().onAttachView(mvpView);
            mIsAttchView = true;
        }
    }

    /**
     * 销毁Presenter持有的View
     */
    private void onDetachView() {
        if (getPresenter() != null && mIsAttchView) {
            getPresenter().onDetachView();
            mIsAttchView = false;
        }
    }

    /**
     * 销毁Presenter
     */
    public void onDestroy() {
        if (getPresenter() != null) {
            onDetachView();
            getPresenter().onDestoryPresenter();
            mPresenter = null;
        }
    }

    /**
     * 意外销毁的时候调用
     *
     * @return Bundle，存入回调给Presenter的Bundle和当前Presenter的id
     */
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (getPresenter() != null) {
            Bundle presenterBundle = new Bundle();
            //回调Presenter
            getPresenter().onSaveInstanceState(presenterBundle);
            bundle.putBundle(PRESENTER_KEY, presenterBundle);
        }
        return bundle;
    }

    /**
     * 意外关闭恢复Presenter
     *
     * @param savedInstanceState 意外关闭时存储的Bundler
     */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        mBundle = savedInstanceState;
    }
}
