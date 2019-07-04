package com.planning.review.base.net01;

import java.net.InetAddress;

public class InetAddressDemo {

	public static void main(String[] args) throws Exception {
		// 根据主机名获取到IP地址对象。
		//InetAddress address = InetAddress.getByName("192.168.0.104");  it is ok
		InetAddress address = InetAddress.getByName("www.baidu.com");
		
		String ip = address.getHostAddress();
		
		String name = address.getHostName();
		
		System.out.println(name + "---" + ip);
	}
}
