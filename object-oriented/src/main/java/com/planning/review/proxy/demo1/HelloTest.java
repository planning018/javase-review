package com.planning.review.proxy.demo1;

import java.lang.reflect.Proxy;

/**
 * Java 动态代理的简单实现
 * @Author: planning
 * @Date: 2019/5/21 16:00
 */
public class HelloTest {

    public static void main(String[] args){
        IHello hello = new HelloProxy();
        HelloLoggerHander loggerHander = new HelloLoggerHander(hello);
        IHello proxy = (IHello) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                hello.getClass().getInterfaces(),
                loggerHander
        );
        proxy.sayHello();
    }
}