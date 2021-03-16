package com.planning.concurrent.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yxc
 * @date 2021/3/16 16:19
 */
@Slf4j
public class ShareObjectWithLock {

    private ReentrantLock lock = new ReentrantLock(true);

    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    private void perform() {
        log.info("Thread - " + Thread.currentThread().getName() + " acquire the lock");
        lock.lock();
        try {
            log.info("Thread - " + Thread.currentThread().getName() + " processing");
            counter++;
        } catch (Exception e) {
            log.info("Interrupt Exception " + e);
        } finally {
            lock.unlock();
            log.info("Thread - " + Thread.currentThread().getName() + " release the lock");
        }
    }

    private void performTryLock() {
        log.info("Thread - " + Thread.currentThread().getName() + " attempting to acquire the lock");

        try {
            // todo 这一块存疑，执行结果和预期不符
            boolean isLockAcquire = lock.tryLock(2, TimeUnit.SECONDS);
            if (isLockAcquire) {
                try {
                    log.info("Thread - " + Thread.currentThread().getName() + " acquire the lock");
                    log.info("Thread - " + Thread.currentThread().getName() + " processing");
                    counter++;
                    Thread.sleep(100);
                } finally {
                    lock.unlock();
                    log.info("Thread - " + Thread.currentThread().getName() + " release the lock");
                }
            } else {
                log.info("Thread - " + Thread.currentThread().getName() + " could not acquire the lock");
            }
        } catch (InterruptedException e) {
            log.info("Interrupt Exception : {0}",  e);
        }
    }

    public static void main(String[] args) throws Exception {
        final int threadCount = 3;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        final ShareObjectWithLock object = new ShareObjectWithLock();

        for (int i = 0; i < 3; i++) {
            //service.submit(object::perform);
            service.submit(object::performTryLock);
        }

        service.shutdown();

        Thread.sleep(10000);
        log.info("counter is {}", object.getCounter());
    }
}
