package com.njrhzn.ew.Activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.njrhzn.ew.App.AppManager;
import com.njrhzn.ew.BroadcastReceiver.NetworkReceiver;
import com.njrhzn.ew.R;

public class EntryToOrderActivity extends MySwipeBackActivity implements View.OnClickListener {
    private ImageButton img_btn_order;
    private NetworkReceiver receiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_entry_to_order;
    }

    @Override
    protected void initView() {
        img_btn_order = (ImageButton) findViewById(R.id.img_btn_order);
        img_btn_order.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void registerReceiver() {
        //注册广播
        if(receiver==null){
            receiver = new NetworkReceiver();
            IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            this.registerReceiver(receiver, filter);
        }
    }

    @Override
    protected void unregisterReceiver() {
        //注销广播
        if (receiver != null) {
            this.unregisterReceiver(receiver);
            receiver = null;
        }
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
            case R.id.img_btn_order:
                Intent intent = new Intent(EntryToOrderActivity.this,ProductListActivity.class);
                EntryToOrderActivity.this.startActivity(intent);
                break;
        }
    }


}
