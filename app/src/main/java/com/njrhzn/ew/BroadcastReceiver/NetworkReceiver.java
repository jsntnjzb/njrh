package com.njrhzn.ew.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.njrhzn.ew.App.MyApp;

public class NetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager conn = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();
        if(networkInfo!=null && !networkInfo.isConnected()){
            Toast.makeText(context,"请检查手机网络连接",Toast.LENGTH_SHORT).show();
            MyApp.getInstance().isConnected = false;
        }else if(networkInfo!=null && networkInfo.getType()==ConnectivityManager.TYPE_WIFI){
            //wifi
            Toast.makeText(context,"已切换至wifi连接",Toast.LENGTH_SHORT).show();
            MyApp.getInstance().isConnected = true;
            MyApp.getInstance().isWifi = true;
        }else if(networkInfo!=null && networkInfo.getType()==ConnectivityManager.TYPE_MOBILE){
            //手机网络
            Toast.makeText(context,"已切换至手机网络连接",Toast.LENGTH_SHORT).show();
            MyApp.getInstance().isConnected = true;
            MyApp.getInstance().isWifi = false;
        }
    }
}
