package com.planning.review.thread.base.demo2;

/**
 * demo测试类
 * @author Administrator
 *
 */
public class TicketDemo {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();

		Thread thread1 = new Thread(ticket);
		Thread thread2 = new Thread(ticket);
		Thread thread3 = new Thread(ticket);

		thread1.start();
		thread2.start();
		thread3.start();
	}
}