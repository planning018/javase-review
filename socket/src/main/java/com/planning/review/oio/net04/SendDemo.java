package com.planning.review.oio.net04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {

	public static void main(String[] args) throws IOException{
		DatagramSocket ds = new DatagramSocket();
		
		//封装键盘录入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = br.readLine()) != null)
		{
			if("886".equals(line)){
				break;
			}
			
			byte[] bys = line.getBytes();
			
			DatagramPacket dp = new DatagramPacket(bys, 0, bys.length,
					                               InetAddress.getByName("192.168.0.104"), 10000);
			ds.send(dp);
		}
		ds.close();
		
	}
}
