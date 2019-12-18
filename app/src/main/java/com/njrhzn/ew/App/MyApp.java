package com.njrhzn.ew.App;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;

public class MyApp extends Application {
    private static MyApp myApp;
    /**
     * 设备号
     */
    public String equipmentId = "";

    /**
     * 网络是否连接
     */
    public boolean isConnected = false;

    /**
     * 是否是Wi-Fi连接
     */
    public boolean isWifi = false;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        equipmentId = GetAndroidId();//Build.SERIAL
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;

    }

    //获取单例
    public static MyApp getInstance() {
        return myApp;
    }

    public String GetAndroidId() {
        String androidID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidID;
    }

    public void clear(){

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
