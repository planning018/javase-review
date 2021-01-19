package com.planning.tools.math;

import java.math.BigDecimal;

/**
 * @author yxc
 * @date 2021/1/18 11:07
 */
public class BigDecimalTools {

    public void descMathPrecision(){
        Double right = 8.2;
        // 存在精度问题
        System.out.println((int)(right.doubleValue() * 100));

        // 解决精度问题
        System.out.println(BigDecimal.valueOf(right).multiply(new BigDecimal(100)).intValue());
        System.out.println(new BigDecimal(String.valueOf(right)).multiply(new BigDecimal(100)).intValue());
    }
}
