package com.simon.uiwatchdog;

import android.app.Application;

import com.simon.uiwatchlib.UiWatchDog;

/**
 * description: 用于测试Application
 * autour: Simon
*/

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UiWatchDog.getDefault().setTag("simon").setTimeOut(1000).watching();
    }
}
