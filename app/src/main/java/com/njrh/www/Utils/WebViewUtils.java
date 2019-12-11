package com.njrh.www.Utils;

import android.os.Build;
import android.webkit.ValueCallback;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.njrh.www.Activity.MainActivity;
import com.njrh.www.App.AppManager;
import com.njrh.www.R;

public class WebViewUtils {
    static BridgeWebView webView;
    static WebViewUtils webViewUtils;

    public WebViewUtils(){
        this.webView = ((MainActivity) AppManager.getAppManager().currentActivity()).findView(R.id.bridge_webView);
    }

    //获取单例
    public static WebViewUtils getInstance() {
        if (webViewUtils == null) {
            synchronized (WebViewUtils.class) {
                if (webViewUtils == null) {
                    webViewUtils = new WebViewUtils();
                }
            }
        }
        return webViewUtils;
    }

    private static class UIRunnable implements Runnable{
        String script;
        UIRunnable(String script_str){
            script = script_str;
        }

        @Override
        public void run() {
            final int version = Build.VERSION.SDK_INT;
            if(version<18){
                webView.loadUrl(script);
            }else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    webView.evaluateJavascript(script, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String s) {
                            //js返回结果
                        }
                    });
                }
            }
        }
    }

    /**
     * android 调用js
     */
    public void CallJs(String script,long time){
        webView.postDelayed(new UIRunnable(script),time);
    }

    public void CallJs(String handlerName, String data, CallBackFunction function){
        webView.callHandler(handlerName, data,function);
    }
}
