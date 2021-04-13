package com.planning.review.oio.net02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP发送数据的步骤：
 * A：创建发送端的Socket服务对象
 * B：创建数据，并把数据打包
 * C：通过Socket对象的发送功能发送数据包
 * D：释放资源 
 *
 */
public class SendDemo {

	public static void main(String[] args) throws IOException {
		//创建发送端的Socket服务对象
		DatagramSocket ds = new DatagramSocket();
		
		byte[] bys = "hello, udp, i am coming".getBytes();
		int length = bys.length;
		
		InetAddress address = InetAddress.getByName("192.168.0.104");
		int port = 10086;
		DatagramPacket p = new DatagramPacket(bys, length, address, port);
		
		//通过Socket对象的发送功能发送数据包
		ds.send(p);
		
		//释放资源
		ds.close();
		
	}
}
