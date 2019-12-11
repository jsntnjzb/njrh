package com.njrh.www.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.njrh.www.App.AppManager;
import com.njrh.www.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton img_btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        img_btn_login = (ImageButton) findView(R.id.img_btn_login);
        img_btn_login.setOnClickListener(this);
    }

    @Override
    protected void addActivity() {
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void finishActivity() {
        AppManager.getAppManager().finishActivity(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void registerReceiver() {

    }

    @Override
    protected void unregisterReceiver() {

    }

    @Override
    protected void removeMessage() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_btn_login:
                //登陆
                Intent intent = new Intent(LoginActivity.this,AdminMenuActivity.class);
                LoginActivity.this.startActivity(intent);
                break;
        }
    }
}
