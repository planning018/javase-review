package com.planning.concurrent.synchronize;

import lombok.Data;

/**
 * @author yxc
 * @date 2021/2/1 19:23
 */
@Data
public class SynchronizedBlocks {

    private int count = 0;
    private static int staticCount = 0;

    void performSyncTask() {
        synchronized (this) {
            setCount(getCount() + 1);
        }
    }

    static void performStaticSyncTask() {
        synchronized (SynchronizedBlocks.class) {
            setStaticCount(getStaticCount() + 1);
        }
    }

    static int getStaticCount() {
        return staticCount;
    }

    static void setStaticCount(int staticCount) {
        SynchronizedBlocks.staticCount = staticCount;
    }
}
