package com.planning.review.thread.base.run;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: planning
 * @Date: 2018/12/17 17:11
 */
public class RunThreadTypeThree implements Callable<String>{


    @Override
    public String call() throws Exception {
        return "Hello Thread";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunThreadTypeThree three = new RunThreadTypeThree();
        FutureTask<String> ft = new FutureTask<String>(three);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}