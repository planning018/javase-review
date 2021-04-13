package com.planning.review.oio.net06;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  TCP协议接收数据的步骤：
 *  A：创建接收数据的Socket对象
 *        创建对象时要指定端口
 *  B：监听客户端连接
 *        等待客户端的连接
 *  C：  获取Socket对象的输入流
 *        是字节流还是字符流？
 *  D： 读取数据，并显示在控制台上
 *  E： 释放资源
 */
public class ServerDemo {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10010);
		
		Socket s = ss.accept();
		
		InputStream input = s.getInputStream();
		
		byte[] bys = new byte[1024];
		int len = input.read(bys);
		String data = new String(bys,0,len);
		System.out.println("data:" + data);
		
		s.close();
		ss.close();
		
	}
}
