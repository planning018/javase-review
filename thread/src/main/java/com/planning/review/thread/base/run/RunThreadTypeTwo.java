package com.planning.review.thread.base.run;

/**
 * @Author: planning
 * @Date: 2018/12/17 17:11
 */
public class RunThreadTypeTwo implements Runnable{

    @Override
    public void run() {
        System.out.println("hello");
    }


    public static void main(String[] args) {
        RunThreadTypeTwo two = new RunThreadTypeTwo();
        Thread thread = new Thread(two);
        thread.start();
    }
}