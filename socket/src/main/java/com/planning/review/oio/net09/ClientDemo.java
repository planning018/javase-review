package com.planning.review.oio.net09;

import java.io.*;
import java.net.Socket;

public class ClientDemo {

	public static void main(String[] args) throws IOException{
		Socket s = new Socket("192.168.0.104",12345);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		String line = null;
		while((line = br.readLine())!= null){
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//禁用输出流
		//s.shutdownOutput();
		
		//获取服务器的反馈
		//把通道内的输入流包装
//		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
//		String data = in.readLine();
//		System.out.println("Client:" + data);
		
		//释放资源
		br.close();
		s.close();
	}
}
