package com.njrh.www.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public abstract class BaseActivity extends Activity {
    public <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            setContentView(layoutId());
            addActivity();
        }
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
        finishActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
        removeMessage();
    }
}
