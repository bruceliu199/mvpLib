package com.example.mvplib.mvp.utils;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by Administrator on 2016/6/7 0007.
 */
public class LogUtil {
    private static final int LOG_LEVEL = 1;
    /**
     * 日志的输出等级
     */
    public static final int LOG_LEVEL_V = 1;
    public static final int LOG_LEVEL_D = 2;
    public static final int LOG_LEVEL_I = 3;
    public static final int LOG_LEVEL_W = 4;
    public static final int LOG_LEVEL_E = 5;
    private static final String TAG = "LOGUTIL-------";

    /**
     * @param string
     */
    public static final void e(String string) {
        if (LOG_LEVEL <= LOG_LEVEL_E && string != null) {
            Log.e(TAG, string);
        }
    }

    /**
     * @param tag
     * @param string
     */
    public static final void e(String tag, String string) {
        if (LOG_LEVEL <= LOG_LEVEL_E && tag != null && string != null) {
            Log.e(tag, string);
        } else {
            e(string);
        }
    }

    /**
     * @param string
     */
    public static final void w(String string) {
        if (LOG_LEVEL <= LOG_LEVEL_W && string != null) {
            Log.w(TAG, string);
        }
    }

    /**
     * @param tag
     * @param string
     */
    public static final void w(String tag, String string) {
        if (LOG_LEVEL <= LOG_LEVEL_W && tag != null && string != null) {
            Log.w(tag, string);
        } else {
            w(string);
        }
    }

    /**
     * @param string
     */
    public static final void i(String string) {
        if (LOG_LEVEL <= LOG_LEVEL_I && string != null) {
            Log.i(TAG, string);
        }
    }

    /**
     * @param tag
     * @param string
     */
    public static final void i(String tag, String string) {
        if (LOG_LEVEL <= LOG_LEVEL_I && tag != null && string != null) {
            Log.i(tag, string);
        } else {
            i(string);
        }
    }

    /**
     * @param string
     */
    public static final void d(String string) {
        if (LOG_LEVEL <= LOG_LEVEL_D && string != null) {
            Log.d(TAG, string);
        }
    }

    /**
     * @param tag
     * @param string
     */
    public static final void d(String tag, String string) {
        if (LOG_LEVEL <= LOG_LEVEL_D && tag != null && string != null) {
            Log.d(tag, string);
        } else {
            d(string);
        }
    }

    /**
     * @param string
     */
    public static final void v(String string) {
        if (LOG_LEVEL <= LOG_LEVEL_V && string != null) {
            Log.d(TAG, string);
        }
    }

    /**
     * @param tag
     * @param string
     */
    public static final void v(String tag, String string) {
        if (LOG_LEVEL <= LOG_LEVEL_V && tag != null && string != null) {
            Log.d(tag, string);
        } else {
            d(string);
        }
    }

    /**
     * @param activity
     * @param message
     */
    public static final void toast(Activity activity, String message) {
        Toast.makeText(activity, "" + message, Toast.LENGTH_SHORT).show();
    }
}
