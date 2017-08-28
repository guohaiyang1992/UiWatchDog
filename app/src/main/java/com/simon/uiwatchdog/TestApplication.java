package com.simon.uiwatchdog;

import android.app.Application;

import com.simon.uiwatchlib.config.BlockTimeBuilder;
import com.simon.uiwatchlib.config.UiWatchDog;

/**
 * description: 用于测试Application
 * autour: Simon
 */

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UiWatchDog.getDefault().setBuilder(new BlockTimeBuilder()).setTag("simon").setTimeBlock(500).build().watchIng();
    }
}
