package com.njrhzn.ew.Activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.njrhzn.ew.Utils.UIRunner;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setTheme(R.style.AppTheme);//恢复原有的样式
        //检查版本更新
        //DownloadUtils downloadUtils = new DownloadUtils("",null);
        //downloadUtils.download("","",new );

        UIRunner.runOnUI(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this,EntryToOrderActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
