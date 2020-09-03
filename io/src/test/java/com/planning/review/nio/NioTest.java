package com.planning.review.nio;

import io.netty.util.NettyRuntime;
import org.junit.Test;

/**
 * @author yxc
 * @since 2020-09-03 14:10
 **/
public class NioTest {

    @Test
    public void test1(){
        System.out.println(NettyRuntime.availableProcessors());
    }
}