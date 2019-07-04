package com.planning.review.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: planning
 * @Date: 2019/5/21 15:55
 */
public class HelloLoggerHander implements InvocationHandler{

    private Object target;

    public HelloLoggerHander(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 此处只是举例说明，实际使用时可为任何方法，下同
        startLog();
        Object result = method.invoke(target,args);
        endLog();
        return result;
    }

    public void startLog(){
        System.out.println("start logging....");
    }

    public void endLog(){
        System.out.println("end logging....");
    }
}