package com.simon.uiwatchlib.utils;

import android.os.Looper;
import android.util.Log;

import com.simon.uiwatchlib.config.Config;
import com.simon.uiwatchlib.core.LogMonitor;

/**
 * description: Log输出辅助工具
 * autour: Simon
 * created at 2017/7/3 上午9:48
 */

public class LogHelper {

    /**
     * 打印 按照时长统计时的内容
     */
    public static void printerBlockInfo() {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        if (stackTrace != null && stackTrace.length >= 4) {
            StackTraceElement method = stackTrace[3];//获取对应执行类的具体信息，排除其他信息
            StringBuilder sb = new StringBuilder();
            sb.append("|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣" + "\n");
            sb.append("|  Ui Thread blocking more than " + Config.TIME_BLOCK + " ms in this postion: " + "\n");
            sb.append("|       " + method.toString() + "\n");
            sb.append("|________________________________________________________________________" + "\n");
            sb.append(" \n");
            Log.e(Config.TAG, sb.toString());
        }
    }

    public static void printerFpsInfo() {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append("|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣" + "\n");
        sb.append("|  Ui Thread skipped more than " + Config.FPS_BLOCK + " frames  " + "\n");
        sb.append("|________________________________________________________________________" + "\n");
        sb.append(" \n");
        Log.e(Config.TAG, sb.toString());
    }

}
