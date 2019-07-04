package com.planning.review.thread.base.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JDK5之后，提供了一个新的方式：Lock锁对象 
 *
 */
public class Ticket implements Runnable {

	private int tickets = 100;
	
	//定义一个锁对象
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {
		while (true) {
            //加锁
			lock.lock();
			if (tickets > 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "正在售出第"
						+ (tickets--) + "张票！");
			} else {
				break;
			}
			//解锁
			lock.unlock();
		}
	}
}