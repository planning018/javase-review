package com.planning.origin;

import org.junit.Test;

import java.math.BigInteger;

/**
 * HashMap 源码分析
 * @Author: planning
 * @Date: 2019/7/23 19:13
 */
public class HashMapAnalyze {

    private final int MAXIMUM_CAPACITY = 1 << 30;

    @Test
    public void test(){
        // 了解一下 源码 的 tableSizeFor 方法
        System.out.println(tableSizeFor(33));;
    }

    private int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}