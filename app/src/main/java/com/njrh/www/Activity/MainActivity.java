package com.njrh.www.Activity;

import android.os.Bundle;

import com.njrh.www.R;

public class MainActivity extends WebViewActivity {

    @Override
    protected String loadUrl() {
        return "file:///android_asset/Html/index.html";
    }

    @Override
    public void initDataBase() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


}
