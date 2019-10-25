package com.planning.concurrent;

/**
 * Concurrent Test Class
 */
public class ConcurrentTest {

    private long count = 0;

    private void addNum(){
        for (int i = 0; i < 10000; i++) {
            count ++;
        }
    }

    private long cal() throws InterruptedException{
        // create two thread
        Thread thread1 = new Thread(this::addNum);
        Thread thread2 = new Thread(this::addNum);

        // start thread
        thread1.start();
        thread2.start();

        // wait for thread end
        thread1.join();
        thread2.join();

        return count;
    }

    public static void main(String[] args) {
        ConcurrentTest test = new ConcurrentTest();
        try {
            System.out.println("cal result is :" + test.cal());;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
