package com.planning.review.proxy.demo1;

/**
 * @Author: planning
 * @Date: 2019/5/21 15:51
 */
public class HelloProxy implements IHello{

    /**
     * 要求在 sayHello 方法的前后加上日志记录
     */
    @Override
    public void sayHello(){
        System.out.println("Hello Proxy.");
    }
}