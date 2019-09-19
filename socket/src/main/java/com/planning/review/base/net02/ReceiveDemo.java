package com.planning.review.base.net02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议操作步骤
 * A：创建接收端的Socket服务对象
 * B：创建一个数据包，用于接收数据
 * C: 接收数据
 * D：解析数据，并显示在控制台上
 * E：释放资源
 */
public class ReceiveDemo {

	public static void main(String[] args) throws IOException {
		//创建接收端的Socket服务对象，并且指定端口号
		DatagramSocket socket = new DatagramSocket(10086);
		
		//创建一个数据包，用于接收数据
		byte[] bys = new byte[1024];  //注意：因为我知道数据量不多，所以指定的是1024
		DatagramPacket packet = new DatagramPacket(bys, bys.length);
		
		//接收数据
		socket.receive(packet);
		
		//解析数据，并显示在控制台上
		InetAddress address = packet.getAddress();
		String ip = address.getHostAddress();
		
		//返回缓冲区数据
		byte[] byss = packet.getData();
		//返回实际长度
		int len = packet.getLength();
		String result = new String(byss, 0, len);
		System.out.println(ip +"-----" +result);
		
		socket.close();
			
		
	}
}
