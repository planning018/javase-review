package com.planning.review.oio.net07;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws IOException {
		//创建服务器对象，并指定端口
		ServerSocket ss = new ServerSocket(10010);
		//监听客户端连接
		Socket s = ss.accept(); //阻塞式
		
		//获取输入流
		InputStream in = s.getInputStream();
		byte[] bys = new byte[1024];
		int len = in.read(bys);  //阻塞式
		String data = new String(bys,0,len);
	    System.out.println("server:" + data);
	    
	    //获取输出流
	    OutputStream out = s.getOutputStream();
	    out.write("数据已收到".getBytes());
	    
	    s.close();
	    ss.close();
		
	}
}
