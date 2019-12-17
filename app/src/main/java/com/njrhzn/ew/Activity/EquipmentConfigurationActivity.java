package com.njrhzn.ew.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.njrhzn.ew.App.AppManager;
import com.njrhzn.ew.R;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

public class EquipmentConfigurationActivity extends MySwipeBackActivity implements View.OnClickListener {
    private ImageButton img_btn_back;
    private SwipeBackLayout mSwipeBackLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSwipeBackEnable(true);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_equipment_configuration;
    }

    @Override
    protected void initView() {
        img_btn_back = (ImageButton) findViewById(R.id.img_btn_back);
        img_btn_back.setOnClickListener(this);
    }

    @Override
    protected void initData() {

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
    protected void addActivity() {
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void finishActivity() {
        AppManager.getAppManager().finishActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_btn_back:
                super.finish();
                finishActivity();
                break;
        }
    }
}
