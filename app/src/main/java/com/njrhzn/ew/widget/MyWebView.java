package com.njrh.ew.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.github.lzyzsd.jsbridge.BridgeWebView;

public class MyWebView extends BridgeWebView {
    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyWebView(Context context) {
        super(context);
    }
}
