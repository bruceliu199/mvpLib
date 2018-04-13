package com.example.administrator.mvpsample;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvplib.mvp.factory.CreatePresenter;
import com.example.mvplib.mvplce.BaseMvpLceActivity;

/**
 * DATE：2018/4/13
 * USER： liuzj
 * DESC：
 * email：liuzj@hi-board.com
 */
@CreatePresenter(LoginPresenter2.class)
public class MvpLceActivity extends BaseMvpLceActivity<String, LoginView2,LoginPresenter2> implements LoginView2 {
    private TextView content;
    @Override
    protected void onInitView(Bundle savedInstanceState) {
        content = (TextView) findViewById(R.id.content);
        loadData(false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvplce;
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        super.loadData(pullToRefresh);
        getPresenter().doLogin();
    }

    @Override
    public void bindData(String data) {
        super.bindData(data);
        content.setText(data);
    }
}
