package com.planning.review.base.net07;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {

	public static void main(String[] args) throws IOException {
		//创建客户端Socket对象，并指定端口和IP
		Socket s = new Socket("192.168.0.104",10010);
		
		//获取输出流
		OutputStream out = s.getOutputStream();
		out.write("tcp，我来了，哈哈".getBytes());
		
		//获取输入流
		InputStream in = s.getInputStream();
		byte[] bys = new byte[1024];
		int len = in.read(bys);//阻塞式
		String data = new String(bys,0,len);
		System.out.println("Client:" + data);
		
		s.close();
		
	}
	
}
