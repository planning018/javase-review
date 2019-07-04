package com.planning.review.base.net05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendThread implements Runnable{

	private DatagramSocket ds;
	
	public SendThread(DatagramSocket ds){
		this.ds = ds;
	}
	
	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while((line = br.readLine())!= null){
				if("886".equals(line)){
					break;
				}
				byte[] bys = line.getBytes();
				DatagramPacket dp = new DatagramPacket(bys, 0, bys.length, 
						                               InetAddress.getByName("192.168.0.104"), 10010);
				ds.send(dp);
			}
			ds.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
