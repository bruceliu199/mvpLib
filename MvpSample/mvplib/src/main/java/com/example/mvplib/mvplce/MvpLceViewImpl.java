package com.example.mvplib.mvplce;

import android.view.View;

import com.example.mvplib.R;


/**
 * 创建时间：2018/3/8
 * 创建人： liuzj
 * 描述：
 * 包名：com.ego.main.mvplce
 * 邮箱：liuzj@hi-board.com
 */
//
public class MvpLceViewImpl<M> implements IMvpLceView<M> {

    private View loadingView;
    private View contentView;
    private View errorView;

    private ILceAnimator lceAnimator;

    /**
     * 初始化视图
     *
     * @param v
     */
    public void initLceView(View v) {
        if (loadingView == null) {
            loadingView = v.findViewById(R.id.loadingView);
        }
        if (contentView == null) {
            contentView = v.findViewById(R.id.contentView);
        }
        if (errorView == null) {
            errorView = v.findViewById(R.id.errorView);
        }
        if (loadingView == null) {
            throw new NullPointerException("loadingView is not null!");
        }
        if (contentView == null) {
            throw new NullPointerException("contentView is not null!");
        }
        if (errorView == null) {
            throw new NullPointerException("errorView is not null!");
        }
    }

    public ILceAnimator getLceAnimator() {
        if (lceAnimator == null) {
//            给一个默认动画
            lceAnimator = DefaultLceAnimator.getInstance();
        }
        return lceAnimator;
    }

    /**
     * 提供设置动画的接口
     *
     * @param lceAnimator
     */
    public void setLceAnimator(ILceAnimator lceAnimator) {
        this.lceAnimator = lceAnimator;
    }

    public void setOnErrorViewClickLitener(View.OnClickListener onClickListener) {
        if (this.errorView != null) {
            this.errorView.setOnClickListener(onClickListener);
        }
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        if (!pullToRefresh) {
            getLceAnimator().showLoading(loadingView, contentView, errorView);
        }
    }

    @Override
    public void showContent(boolean pullToRefresh) {
        if (!pullToRefresh) {
            getLceAnimator().showContent(loadingView, contentView, errorView);
        }
    }

    @Override
    public void showError() {
        getLceAnimator().showErrorView(loadingView, contentView, errorView);
    }

    @Override
    public void bindData(M data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }


}
