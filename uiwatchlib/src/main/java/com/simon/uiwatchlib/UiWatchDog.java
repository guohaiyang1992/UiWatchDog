package com.simon.uiwatchlib;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

/**
 * description: 用于总体配置
 * autour: Simon
 * created at 2017/7/1 下午8:20
 */

public class UiWatchDog {
    //  public static void start() {

//        Looper.getMainLooper().setMessageLogging();

    //}
    public static final String TAG = "UiWatchDog";

    private static UiWatchDog mInstance = new UiWatchDog();

    private UiWatchDog() {

    }

    public static UiWatchDog getDefault() {
        return mInstance;
    }

    /**
     * 打印信息的时候的tag
     *
     * @param tag --打印信息的tag
     * @return
     */
    public UiWatchDog setTag(String tag) {
        if (TextUtils.isEmpty(tag)) {
            Log.e(TAG, "当前设置的tag无效，将使用默认tag: UiWatchDog !");
        } else {
            LogMonitor.TAG = tag;
        }
        return this;
    }

    /**
     * 设置阈值，超时则打印信息
     *
     * @param time --阈值时间，超出时候打印log,单位： ms
     * @return
     */
    public UiWatchDog setTimeOut(long time) {
        if (time <= 0) {
            time = 1000l;
            Log.e(TAG, "当前设置的time无效，将使用默认time: 1000ms !");
        } else {
            LogMonitor.TIME_BLOCK = time;
        }
        return this;
    }

    /**
     * 开启监听的方法，该方法执行在设置参数之后，否则参数无效
     */
    public void watching() {
        Looper.getMainLooper().setMessageLogging(BlockPrinter.getDefault());
    }


}
