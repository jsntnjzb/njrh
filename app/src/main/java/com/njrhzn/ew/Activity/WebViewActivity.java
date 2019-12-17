package com.njrhzn.ew.Activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.BridgeWebViewClient;
import com.njrhzn.ew.App.AppManager;
import com.njrhzn.ew.Handler.IndexHandler;
import com.njrhzn.ew.R;

import java.lang.ref.WeakReference;
import java.util.Map;

public abstract class WebViewActivity extends BaseActivity {
    private String url;
    private String curr_url;
    private Map<String, String> params;
    private BridgeWebView bridgeWebView;
//    private MyBridgeHandler myBridgeHandler;
    private String TAG = "WebViewActivity";

    protected abstract String loadUrl();

    public abstract void initDataBase();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerReceiver();
        initView();
        initData();
        initDataBase();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "onkeydown:" + keyCode);
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0) {
                    return false;
                }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void initView() {
        bridgeWebView = findView(R.id.bridge_webView);
        if (!TextUtils.isEmpty(loadUrl())) {
            setWebView(loadUrl());
        }
        showWebView();
    }


    @Override
    public void initData() {
        TAG = getClass().getName();
    }

    @Override
    public void registerReceiver() {

    }

    @Override
    protected void unregisterReceiver() {
        //        unregisterReceiver(mUsbReceiver);
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
        AppManager.getAppManager().finishActivity();
    }

    private void setWebView(String url) {
        this.url = url;
        setting();
    }

    private void setting() {
        WebSettings settings = bridgeWebView.getSettings();
        bridgeWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        bridgeWebView.setVerticalScrollBarEnabled(true);
        bridgeWebView.setHorizontalScrollBarEnabled(false);
        settings.setUseWideViewPort(true);//设置webview推荐使用的窗口
        settings.setLoadWithOverviewMode(true);//设置webview加载的页面的模式
        settings.setBuiltInZoomControls(false); // 显示放大缩小
        settings.setSupportZoom(true); // 可以缩放
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setAllowFileAccess(true); // 允许访问文件
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            settings.setAllowFileAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        /**
         * 解决跨域访问的问题
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            settings.setAllowFileAccessFromFileURLs(true);
        }
        //设置编码方式
        settings.setDefaultTextEncodingName("utf-8");

        //主要用于平板，针对特定屏幕代码调整分辨率
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int mDensity = metrics.densityDpi;
        if (mDensity == 240) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else if (mDensity == 160) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        } else if (mDensity == 120) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        } else if (mDensity == DisplayMetrics.DENSITY_XHIGH) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else if (mDensity == DisplayMetrics.DENSITY_TV) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else {
            settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        }

        /**
         * 用WebView显示图片，可使用这个参数 设置网页布局类型：
         * 1、LayoutAlgorithm.NARROW_COLUMNS ：适应内容大小
         * equipment_statistics、LayoutAlgorithm.SINGLE_COLUMN:适应屏幕，内容将自动缩放
         */
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    }

    private void showWebView() {
        bridgeWebView.loadUrl(url);
        bridgeWebView.setWebViewClient(new myWebViewClient(bridgeWebView));
        bridgeWebView.setWebChromeClient(new webChromeClient());
        bridgeWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Log.d(TAG, "onkeydown:" + keyEvent.getKeyCode());
                return false;
            }
        });

    }

    private class myWebViewClient extends BridgeWebViewClient {
        public myWebViewClient(BridgeWebView webView) {
            super(webView);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            handler.proceed();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d(TAG, "onPageFinished");
            curr_url = url;
            //注册js调用的后台方法
            registerHandler(curr_url);
        }
    }

    private class webChromeClient extends WebChromeClient {

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        destory();
    }


    public void registerHandler(String url) {
        switch (url){
            case "file:///android_asset/Html/index.html":
                IndexHandler loginHandler = new IndexHandler("login",bridgeWebView,new WeakReference<Context>(WebViewActivity.this));
                loginHandler.register_handler();

                IndexHandler invalidateHandler = new IndexHandler("invalidatePwd",bridgeWebView,new WeakReference<Context>(WebViewActivity.this));;
                invalidateHandler.register_handler();
                break;
        }
    }

    public void destory () {
        if (bridgeWebView != null) {
            ViewParent parent = bridgeWebView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(bridgeWebView);
            }
            bridgeWebView.stopLoading();
            bridgeWebView.getSettings().setJavaScriptEnabled(false);
            bridgeWebView.clearHistory();
            bridgeWebView.clearView();
            bridgeWebView.removeAllViews();
            bridgeWebView.destroy();
        }
    }
}
