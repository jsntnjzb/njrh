package com.njrhzn.ew.Handler;

import android.content.Context;
import android.text.TextUtils;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.njrh.ew.Utils.ToastUtils;

import java.lang.ref.WeakReference;

public class IndexHandler extends MyBridgeHandler {
    public IndexHandler(String handler_name, BridgeWebView bridgeWebView, WeakReference<Context> contextWeakReference) {
        super(handler_name, bridgeWebView, contextWeakReference);
    }

    @Override
    public void handler(String data, CallBackFunction function) {
        super.handler(data, function);
        //编写逻辑
        switch (handler_name){
            case "login":
                login();
                break;
            case "invalidatePwd":
                if(!TextUtils.isEmpty(client_data)){
                    ToastUtils.showToastAtCenter(contextWeakReference.get(),client_data);
                }
                break;
        }
    }

    @Override
    public void register_handler() {
        super.register_handler();
    }

    @Override
    public void setHandler_name(String handler_name) {
        super.setHandler_name(handler_name);
    }

    //登陆
    private void login(){
        if(TextUtils.isEmpty(client_data)){
            ToastUtils.showToastAtCenter(contextWeakReference.get(),"请输入密码");
        }else if(!client_data.equals("12345678")){
            ToastUtils.showToastAtCenter(contextWeakReference.get(),"密码不正确");
        }else {

        }
    }
}
