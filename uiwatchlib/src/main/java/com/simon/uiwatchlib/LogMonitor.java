package com.simon.uiwatchlib;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MemoryFile;
import android.util.Log;

/**
 * description: log监听类
 * autour: Simon
 * created at 2017/7/1 下午8:20
 */

public class LogMonitor {
    private static LogMonitor sInstance = new LogMonitor();//静态单例
    private HandlerThread mLogThread = new HandlerThread("background_log_thread");//打印线程的handle
    private Handler mIoHandler;// log的handler
    public static long TIME_BLOCK = 1000L;//默认block time
    public static String TAG = "UiWatchDog"; //默认tag

    private LogMonitor() {
        mLogThread.start();//运行线程
        mIoHandler = new Handler(mLogThread.getLooper());//得到线程中的handle
    }

    /**
     * 打印堆栈
     */
    private static Runnable mLogRunnable = new Runnable() {
        @Override
        public void run() {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 4) {
                StackTraceElement method = stackTrace[3];//获取对应执行类的具体信息，排除其他信息
                printer(method);
            }
        }
    };

    public static LogMonitor getInstance() {
        return sInstance;
    }


    public void startMonitor() {
        mIoHandler.postDelayed(mLogRunnable, TIME_BLOCK);
    }

    public void removeMonitor() {
        mIoHandler.removeCallbacks(mLogRunnable);
    }

    public static void printer(StackTraceElement method) {
        StringBuilder sb = new StringBuilder();
        sb.append("|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣" + "\n");
        sb.append("|  Ui Thread blocking more than " + TIME_BLOCK + " ms in this postion: " + "\n");
        sb.append("|       " + method.toString() + "\n");
        sb.append("|________________________________________________________________________" + "\n");
        sb.append(" \n");
        Log.e(TAG, sb.toString());
    }
}
