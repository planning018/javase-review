package com.planning.review.base.net04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(10000);

		while (true) {
			byte[] bys = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bys, 0, bys.length);
			ds.receive(dp);

			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0, dp.getLength());
			
			System.out.println("from "+ ip +" data is "+ data);
		}
	}
}
