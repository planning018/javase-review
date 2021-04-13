package com.planning.review.oio.net01;

import java.net.InetAddress;

public class InetAddressDemo {

	public static void main(String[] args) throws Exception {
		// get an IP address by host name
		InetAddress address = InetAddress.getByName("www.baidu.com");
		
		String ip = address.getHostAddress();
		
		String name = address.getHostName();
		
		System.out.println(name + "---" + ip);
	}
}
