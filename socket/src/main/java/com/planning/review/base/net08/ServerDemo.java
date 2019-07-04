package com.planning.review.base.net08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws IOException{
		//创建服务端socket对象
		ServerSocket ss = new ServerSocket(10010);
		//监听客户端
		Socket s =  ss.accept();
		
		//封装输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while((line = br.readLine())!= null){
			System.out.println("server :" + line);
		}
		//释放资源
		s.close();
		ss.close();
		
	}
}
