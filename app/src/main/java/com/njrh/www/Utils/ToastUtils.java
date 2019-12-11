package com.njrh.www.Utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtils {
    private static long time = 0;
    private static String last = "";

    public static boolean isTooFast() {
        return isTooFast(600);
    }

    public static boolean isTooFast(int delay) {
        long curTime = System.currentTimeMillis();
        long span = curTime - time;
        time = curTime;
        if (span < delay) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSame(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            if (msg.equals(last))
                return true;
        }
        last = msg;
        return false;
    }

    public static void showToast(final Context context, final String msg) {
        if (!isTooFast() || !isSame(msg)) {
            UIRunner.runOnUI(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }, 100);
        }
    }

    public static void showToast(Context context,int resId) {
        String msg = context.getString(resId);
        showToast(context,msg);
    }

    public static void showToastAtCenter(Context context,String msg) {
        if (isTooFast())
            return;
        if (context == null)
            return;

        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showToastAtCenter(Context context,int resId) {
        if (isTooFast())
            return;
        if (context == null)
            return;

        Toast toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showToastAtTop(Context context,String msg) {
        if (isTooFast())
            return;
        if (context == null)
            return;
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 200);
        toast.show();
    }

    public static void showToastAtTop(Context context,int resId) {
        if (isTooFast())
            return;
        if (context == null)
            return;
        Toast toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 200);
        toast.show();
    }
}
