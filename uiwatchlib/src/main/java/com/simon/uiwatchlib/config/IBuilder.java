package com.simon.uiwatchlib.config;

/**
 * Created by guohaiyang on 2017/7/3.
 */

public abstract class IBuilder {
    abstract void watchIng();

    IBuilder build() {
        Config.TAG = getTag();
        Config.TIME_BLOCK = getTimeBlock();
//        Config.FPS_BLOCK = getFpsBlock();
//        Config.FPS_TIME_BLOCK = getFpsTimeBlock();
        return this;
    }

//    protected abstract long getFpsTimeBlock();

//    protected abstract long getFpsBlock();

    protected abstract long getTimeBlock();

    protected abstract String getTag();

    public abstract IBuilder setTag(String tag);

    public abstract IBuilder setTimeBlock(long timeBlock);


}
