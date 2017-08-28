package com.simon.uiwatchlib.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import com.simon.uiwatchlib.config.Config;
import com.simon.uiwatchlib.utils.LogHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * description: log监听类
 * autour: Simon
 * created at 2017/7/1 下午8:20
 */

public class LogMonitor {
    private static LogMonitor sInstance = new LogMonitor();//静态单例
    private HandlerThread mLogThread = new HandlerThread("background_log_thread");//打印线程的handle
    private Handler mIoHandler;// log的handler


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
            LogHelper.printerBlockInfo();
        }
    };


    public static LogMonitor getInstance() {
        return sInstance;
    }

    public boolean isMonitor() {
        return innerIsMonitor();
    }

    public void startMonitor() {
        mIoHandler.postDelayed(mLogRunnable, Config.TIME_BLOCK);
    }

    public void removeMonitor() {
        mIoHandler.removeCallbacks(mLogRunnable);
    }

    /**
     * 反射方法，hasCallbacks 是hidden
     *
     * @return
     */
    private boolean innerIsMonitor() {
        if (mIoHandler != null && mLogRunnable != null) {
            try {
                Method m1 = mIoHandler.getClass().getDeclaredMethod("hasCallbacks", Runnable.class);
                m1.setAccessible(true);
                Object result = m1.invoke(mIoHandler, mLogRunnable);
                return (boolean) result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
