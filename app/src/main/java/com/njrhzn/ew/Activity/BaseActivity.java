package com.njrhzn.ew.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public abstract class BaseActivity extends Activity {
    public <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            setContentView(layoutId());
            initView();
            addActivity();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    protected abstract int layoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void registerReceiver();

    protected abstract void unregisterReceiver();

    protected abstract void removeMessage();

    protected abstract void addActivity();

    protected abstract void finishActivity();


    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
        removeMessage();
    }
}
