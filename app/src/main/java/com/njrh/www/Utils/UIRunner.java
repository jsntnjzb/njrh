package com.njrh.www.Utils;

import android.os.Handler;
import android.os.Looper;

public class UIRunner {
    static Handler mHandler;

    public static void runOnUI(Runnable runnable) {
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }
        mHandler.post(runnable);
    }

    public static void runOnUI(Runnable runnable, long delayMs) {
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }
        mHandler.postDelayed(runnable, delayMs);
    }
}
