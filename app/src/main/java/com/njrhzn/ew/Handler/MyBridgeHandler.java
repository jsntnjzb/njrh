package com.njrh.ew.Handler;

import android.content.Context;
import android.text.TextUtils;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.njrh.ew.Utils.LogUtils;
import com.njrh.ew.Utils.ToastUtils;

import java.lang.ref.WeakReference;


public class MyBridgeHandler implements BridgeHandler {
    public String handler_name;
    private BridgeWebView bridgeWebView;
    public WeakReference<Context> contextWeakReference;
//    private Handler_action handler_action;
    public String client_data;//前端js有传过来的值
    public String callback_data;//返回给js的数据

    public MyBridgeHandler(String handler_name, BridgeWebView bridgeWebView, WeakReference<Context> contextWeakReference) {
        this.handler_name = handler_name;
        this.bridgeWebView = bridgeWebView;
        this.contextWeakReference = contextWeakReference;
    }

    public void setHandler_name(String handler_name) {
        this.handler_name = handler_name;
    }

    public void setBridgeWebView(BridgeWebView bridgeWebView) {
        this.bridgeWebView = bridgeWebView;
    }
    public void setContextWeakReference(WeakReference<Context> contextWeakReference) {
        this.contextWeakReference = contextWeakReference;
    }

    public void setCallback_data(String callback_data) {
        this.callback_data = callback_data;
    }

    public String getClient_data() {
        return client_data;
    }

    public void setClient_data(String client_data) {
        this.client_data = client_data;
    }

    @Override
    public void handler(String data, CallBackFunction function) {
        //前端js有传过来的值
        if(!TextUtils.isEmpty(data)){
            client_data = data;
        }
        if(!TextUtils.isEmpty(callback_data)){
            function.onCallBack(callback_data);
        }
        //handler_action.action();
    }

    public void register_handler(){
        if(contextWeakReference==null){
            LogUtils.e("contextWeakReference is null");
            return;
        }

        if(bridgeWebView==null){
            ToastUtils.showToast(contextWeakReference.get(),"bridgeWebView is null");
            return;
        }
        if(TextUtils.isEmpty(handler_name)){
            ToastUtils.showToast(contextWeakReference.get(),"handler_name is empty");
            return;
        }
        bridgeWebView.registerHandler(handler_name,this);
    }

    public interface Handler_action{
        void action();
    }
}
