package com.example.administrator.mvpsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvplib.mvp.BaseMvpActivity;
import com.example.mvplib.mvp.factory.CreatePresenter;

/**
 * DATE：2018/4/13
 * USER： liuzj
 * DESC：
 * email：liuzj@hi-board.com
 */
@CreatePresenter(LoginPresenter.class)
public class MvpActivity extends BaseMvpActivity<LoginView, LoginPresenter> implements LoginView {

    private TextView content;
    private ProgressBar pb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        content = (TextView) findViewById(R.id.content);
        pb = (ProgressBar) findViewById(R.id.pb);
        getPresenter().doLogin();

    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccess(String response) {
        pb.setVisibility(View.GONE);
        content.setText(response);
    }

    @Override
    public void onFaile(String error) {
        pb.setVisibility(View.GONE);
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
