package com.planning.review.base.net03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket ds = new DatagramSocket(10010);
		
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, 0, bys.length);
		
		ds.receive(dp);
		
		String ip = dp.getAddress().getHostAddress();
		
		String data = new String(dp.getData(),0,dp.getLength());
		
		System.out.println("from "+ ip +" data is "+ data);
		
		ds.close();
		
	}
}
