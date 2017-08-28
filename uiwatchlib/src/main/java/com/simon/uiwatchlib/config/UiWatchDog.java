package com.simon.uiwatchlib.config;

/**
 * description: 用于总体配置
 * autour: Simon
 * created at 2017/7/1 下午8:20
 */

public class UiWatchDog {

    public static final String TAG = "UiWatchDog";

    private static UiWatchDog mInstance = new UiWatchDog();

    private IBuilder builder;

    private UiWatchDog() {

    }

    public static UiWatchDog getDefault() {
        return mInstance;
    }


    public UiWatchDog setBuilder(IBuilder builder) {
        this.builder = builder;
        return this;
    }

    public UiWatchDog setTag(String tag) {
        if (isBuildNotBull()) {
            builder.setTag(tag);
        }
        return this;
    }

    public UiWatchDog setTimeBlock(long time) {
        if (isBuildNotBull()) {
            builder.setTimeBlock(time);
        }
        return this;
    }

    public UiWatchDog build() {
        if (isBuildNotBull()) {
            builder.build();
        }
        return this;
    }

    public void watchIng() {
        if (isBuildNotBull()) {
            builder.watchIng();
        }
    }

    private boolean isBuildNotBull() {
        return builder != null;
    }


}
