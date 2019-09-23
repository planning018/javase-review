package com.planning.review.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 学习一下 FutureTask 的用法
 */
public class FutureTaskDemo {

    public static void main(String[] args) {
        Callable callable = () -> {
            System.out.println("begin to cook food");
            Thread.sleep(5000);
            return "food cook is ok";
        };

        FutureTask<String> futureTask = new FutureTask<String>(callable);
        new Thread(futureTask).start();
        System.out.println("begin to make coke");
        try {
            // assume make cook cost 3000ms
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("coke is ok");

        if(!futureTask.isDone()){
            System.out.println("food is not ok, please wait 3000 ms");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
