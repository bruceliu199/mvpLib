package com.example.mvplib.mvplce;


import com.example.mvplib.mvp.base.IBaseMvpView;

/**
 * 创建时间：2018/3/8
 * 创建人： liuzj
 * 描述：Loading - content - Error三种状态
 * 包名：com.ego.main.mvplce
 * 邮箱：liuzj@hi-board.com
 */
//定义场景接口 加载——>展示内容——>错误页  绑定数据  加载数据
public interface IMvpLceView<D> extends IBaseMvpView {

    /**
     * 展示加载过程
     * <b>The loading view must have the id = R.id.loadingView</b>
     * 布局里面必须放置R.id.loadingView的view
     * @param pullToRefresh 是否是具有下拉刷新组件
     */
    void showLoading(boolean pullToRefresh);


    /**
     * 展示内容，我们实际开发所要展示的界面
     * 内容的根节点必须是id为R.id.contentView
     * <b>The content view must have the id = R.id.contentView</b>
     * @param pullToRefresh
     */
    void showContent(boolean pullToRefresh);

    /**
     * 显示异常界面
     *<b>The error view must bethe id = R.id.errorView</b>
     * errorview的id必须是R.id.errorView
     */
    void showError();

    /**
     * 绑定数据
     *
     * @param data
     */
    void bindData(D data);

    /**
     * 加载数据
     *
     * @param pullToRefresh 是否有下拉刷新组件
     */
    void loadData(boolean pullToRefresh);
}
