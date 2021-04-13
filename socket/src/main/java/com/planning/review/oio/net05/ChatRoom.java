package com.planning.review.oio.net05;

import java.io.IOException;
import java.net.DatagramSocket;

/**
 * 多线程改进聊天
 * @author Administrator
 *
 */
public class ChatRoom {

	public static void main(String[] args) throws IOException {
		DatagramSocket dsReccive = new DatagramSocket(10010);
		DatagramSocket dsSend = new DatagramSocket();
		
		ReceiveThread receiveThread = new ReceiveThread(dsReccive);
		SendThread sendThread = new SendThread(dsSend);
		
		Thread thread1 = new Thread(receiveThread);
		Thread thread2 = new Thread(sendThread);
		
		thread1.start();
		thread2.start();
	}
}
