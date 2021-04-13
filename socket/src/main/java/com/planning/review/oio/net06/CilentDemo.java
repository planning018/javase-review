package com.planning.review.oio.net06;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP协议发送数据的步骤：
 * A：创建发送对象的Socket对象。 
 *     创建对象的时候要指定目标主机和端口 
 * B：获取Socket对象的输出流
 * C：写数据
 * D：释放资源
 */
public class CilentDemo {

	public static void main(String[] args) throws IOException {
		//创建发送对象的Socket对象
		Socket s = new Socket("192.168.0.104", 10010);
		//获取Socket对象的输出流
		OutputStream out = s.getOutputStream();
		
		//写数据
		out.write("hello, i am coming".getBytes());
		//释放资源
		out.close();
	}
}
