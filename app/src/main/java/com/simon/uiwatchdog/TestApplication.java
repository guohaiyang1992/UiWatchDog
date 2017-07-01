package com.simon.uiwatchdog;

import android.app.Application;

import com.simon.uiwatchlib.UiWatchDog;

/**
 * Created by guohaiyang on 2017/7/1.
 */

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UiWatchDog.getDefault().setTag("simon").setTimeOut(1000).watching();
    }
}
