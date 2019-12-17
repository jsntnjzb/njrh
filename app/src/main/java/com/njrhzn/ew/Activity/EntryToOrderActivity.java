package com.njrhzn.ew.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.njrhzn.ew.R;

public class EntryToOrderActivity extends Activity implements View.OnClickListener {
    private ImageButton img_btn_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_to_order);
        img_btn_order = (ImageButton) findViewById(R.id.img_btn_order);
        img_btn_order.setOnClickListener(this);
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
