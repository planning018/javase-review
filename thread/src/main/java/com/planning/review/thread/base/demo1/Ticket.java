package com.planning.review.thread.base.demo1;
/**
 * 简单总结：
 *   1.同步代码块的锁对象是谁？
 *       ---> 任意对象
 *   2.同步方法的锁对象是谁？
 *       ---> this对象
 *   3.静态方法的锁对象是谁？
 *       ---> Ticket.class 当前类的字节码文件对象
 */
public class Ticket implements Runnable {

	private int tickets = 100;
	private Object obj = new Object();

	@Override
	public void run() {
		while (true) {
			//同步代码块，使用obj作为锁对象
			synchronized (obj) {
				if (tickets > 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ "正在售出第" + (tickets--) + "张票！");
				} else {
					break;
				}
			}
		}
	}
}