package com.example.mvplib.mvplce;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.mvplib.mvp.BaseMvpActivity;
import com.example.mvplib.mvp.base.BaseMvpPresenter;
import com.example.mvplib.mvp.base.IBaseMvpView;


/**
 * 创建时间：2018/3/12
 * 创建人： liuzj
 * 描述：需要lce流程的活动可继承此类（建议该页面接口为一个，数据类型汇总单一）
 * D为具体的数据类型，V为具体的继承自IMvpLceView的view层接口   P为具体的继承自BaseMvpPresenter的Presenter
 * 包名：com.ego.main.mvplce
 * 邮箱：liuzj@hi-board.com
 */
//D要绑定的数据类型
public abstract class BaseMvpLceActivity<D, V extends IBaseMvpView, P extends BaseMvpPresenter<V>> extends BaseMvpActivity<V, P>
        implements IMvpLceView<D> {

    //持有目标对象的引用
    private MvpLceViewImpl<D> lceView;

    public void setLceView(MvpLceViewImpl<D> lceView) {
        this.lceView = lceView;
    }

    public MvpLceViewImpl<D> getLceView() {
        if (lceView == null) {
            lceView = new MvpLceViewImpl<D>();
        }
        return lceView;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //获取根视图
        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        //初始化Lceview
        initLceView(rootView);

        onInitView(savedInstanceState);
    }

    private void initLceView(View rootView) {
        getLceView().initLceView(rootView);
        getLceView().setOnErrorViewClickLitener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //做个点击重新加载
                onErrorClick();
            }
        });
    }

    private void onErrorClick() {
        loadData(false);
    }

    //设置动画策略
    public void setLceAnimator(ILceAnimator animator) {
        getLceView().setLceAnimator(animator);
    }

    //重载IMvpLceView中的函数
    @Override
    public void showLoading(boolean pullToRefresh) {
        getLceView().showLoading(pullToRefresh);
    }

    @Override
    public void showContent(boolean pullToRefresh) {
        getLceView().showContent(pullToRefresh);
    }

    @Override
    public void showError() {
        getLceView().showError();
    }

    @Override
    public void bindData(D data) {
        getLceView().bindData(data);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        getLceView().loadData(pullToRefresh);
    }


    protected abstract void onInitView(Bundle savedInstanceState);

    protected abstract int getLayoutId();
}
