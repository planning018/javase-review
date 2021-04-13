package com.planning.review.oio.net03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket ds = new DatagramSocket();
		
		byte[] bys = "好好学习，天天向上".getBytes();
		
		DatagramPacket dp = new DatagramPacket(bys, bys.length, 
				                               InetAddress.getByName("192.168.0.104"), 10010);
		ds.send(dp);
		
		ds.close();
	}
}
