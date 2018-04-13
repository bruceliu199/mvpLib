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
//工厂实现类
public class PresenterFactoryImpl<V extends IBaseMvpView, P extends BaseMvpPresenter<V>> implements IPresenterFactory<V, P> {

    private Class<P> presenterClazz;
    //根据注解创建presenter的工厂实现类
    public static <V extends IBaseMvpView, P extends BaseMvpPresenter<V>> PresenterFactoryImpl<V, P> createFactory(Class<?> viewClazz) {
        CreatePresenter annotation = viewClazz.getAnnotation(CreatePresenter.class);
        Class<P> aClass = null;
        if (annotation != null) {
            aClass = (Class<P>) annotation.value();
        }

        return aClass == null ? null : new PresenterFactoryImpl<V, P>(aClass);
    }

    public PresenterFactoryImpl(Class<P> presenterClazz) {
        this.presenterClazz = presenterClazz;
    }

    @Override
    public P createPresenter() {
        try {
            return this.presenterClazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter 创建失败！检查是否声明了@CreatePresenter(xxPresenter.class)注解");
        }
    }
}
