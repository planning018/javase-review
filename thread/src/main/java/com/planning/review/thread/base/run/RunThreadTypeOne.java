package com.planning.review.thread.base.run;

/**
 * @Author: planning
 * @Date: 2018/12/17 17:11
 */
public class RunThreadTypeOne extends Thread{

    @Override
    public void run() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        RunThreadTypeOne one = new RunThreadTypeOne();
        one.start();
    }

}