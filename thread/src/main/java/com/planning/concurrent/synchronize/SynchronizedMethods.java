package com.planning.concurrent.synchronize;

import lombok.Data;

/**
 * synchronized 关键字 - 锁定方法
 *
 * @author yxc
 * @date 2021/2/1 19:09
 */
@Data
public class SynchronizedMethods {

    private int sum = 0;
    private int synSum = 0;

    static int staticSum = 0;

    void calculate(){
        setSum(getSum() + 1);
    }

    synchronized void synchronizedCalculate(){
        setSynSum(getSynSum() + 1);
    }

    static synchronized void syncStaticCalculate(){
        staticSum = staticSum + 1;
    }
}
