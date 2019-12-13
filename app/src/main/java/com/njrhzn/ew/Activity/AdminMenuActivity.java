package com.njrhzn.ew.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.njrhzn.ew.App.AppManager;
import com.njrhzn.ew.R;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

public class AdminMenuActivity extends MySwipeBackActivity implements View.OnClickListener {
    private ImageButton img_btn_equipment_configuration,img_btn_equipment_statistics;
    Intent intent;
    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSwipeBackEnable(true);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    @Override
    protected void initView() {
        img_btn_equipment_configuration = (ImageButton) findViewById(R.id.img_btn_equipment_configuration);
        img_btn_equipment_statistics = (ImageButton) findViewById(R.id.img_btn_equipment_statistics);
        img_btn_equipment_configuration.setOnClickListener(this);
        img_btn_equipment_statistics.setOnClickListener(this);
    }

    @Override
    protected void initData() {

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
        return R.layout.activity_admin_menu;
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
            //设备配置页
            case R.id.img_btn_equipment_configuration:
                intent = new Intent(AdminMenuActivity.this,EquipmentConfigurationActivity.class);
                AdminMenuActivity.this.startActivity(intent);
                break;
                //设备销量统计
            case R.id.img_btn_equipment_statistics:
                intent = new Intent(AdminMenuActivity.this,Equipment_sales_statisticsActivity.class);
                AdminMenuActivity.this.startActivity(intent);
                break;
        }
    }
}
