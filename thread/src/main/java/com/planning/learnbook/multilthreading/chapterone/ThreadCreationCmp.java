package com.planning.learnbook.multilthreading.chapterone;

/**
 * 《Java 多线程编程实战指南》 第一章
 * 线程的两种创建方式的区别
 *
 * @Author: planning
 * @Date: 2019/7/20 16:11
 */
public class ThreadCreationCmp {

    /**
     * 程序结果：
     *        "countTask" 的值略小于 2 * 4 * 100
     *        "countThread" 的值一直小于 100
     *     ===> 竞争和线程安全
     * @param args
     */
    public static void main(String[] args) {

        Thread t;
        CountingTask countingTask = new CountingTask();

        // 获取处理器个数
        final int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("number of processors is " + numberOfProcessors);

        for (int i = 0; i < 2 * numberOfProcessors; i++){
            // 直接创建线程
            t = new Thread(countingTask);
            t.start();
        }

        for (int i = 0; i < 2 * numberOfProcessors; i++){
            // 以子类的方式创建线程
            t = new CountThread();
            t.start();
        }

    }

    static class Counter{
        private int count;

        public void increment(){
            count++;
        }

        public int getCount(){
            return count;
        }
    }

    static class CountingTask implements Runnable {

        private Counter counter = new Counter();

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                doSomething();
                counter.increment();
                System.out.println("CountTask : " + counter.getCount());
            }
        }

        private void doSomething(){
            // 使当前线程休眠随机时间
            Tools.pause(80);
        }
    }


    static class CountThread extends Thread {
        private Counter counter = new Counter();

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                doSomething();
                counter.increment();
                System.out.println("CountThread : " + counter.getCount());
            }
        }

        private void doSomething(){
            // 使当前线程休眠随机时间
            Tools.pause(80);
        }
    }


    static class Tools {

        public static void pause(long timeValue){
            try {
                Thread.sleep(timeValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}