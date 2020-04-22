package com.planning.review.thread.future;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 学习一下 FutureTask 的用法
 *
 * @author planning 2019.09.23
 */
public class FutureTaskDemo {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(),
            new ThreadFactoryBuilder().setNameFormat("planning-thread-%d").build());

    public static void main(String[] args) {

        // 在主线程中，启动 FutureTask 任务
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println("begin to cook food");
            Thread.sleep(5000);
            return "food cook is ok";
        });
        // 提交到 线程池 中执行
        executor.submit(futureTask);
        System.out.println("begin to make coke");
        try {
            // 主线程等待： assume make cook cost 3000ms
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("coke is ok");

        if (!futureTask.isDone()) {
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
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
