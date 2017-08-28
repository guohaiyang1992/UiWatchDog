package com.simon.uiwatchlib.core;

import android.util.Printer;

/**
 * description: 日志打印 监听
 * autour: Simon
 * created at 2017/7/1 下午8:21
 */

public class BlockPrinter implements Printer {
    // main looper 日志打印的开始和结束
    private static final String START = ">>>>> Dispatching";
    private static final String END = "<<<<< Finished";
    private static BlockPrinter mInstance = new BlockPrinter();

    private BlockPrinter() {

    }

    public static BlockPrinter getDefault() {
        return mInstance;
    }

    //打印开始的时候开始监视，但因结束的时候关闭监视，如果，超过时间，则打印信息
    @Override
    public void println(String x) {
        if (x.startsWith(START)) {
            LogMonitor.getInstance().startMonitor();
        }
        if (x.startsWith(END)) {
            LogMonitor.getInstance().removeMonitor();
        }
    }
}
