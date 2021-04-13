package com.planning.review.oio.net09;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(12345);
		Socket s = ss.accept();
		
		//包装输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//输出流
		BufferedWriter bw = new BufferedWriter(new FileWriter("./net/net09.txt"));
		
		String line = null;
		while((line = br.readLine())!= null){
			if("over".equals(line)){
				break;
			}
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//给客户端一个反馈
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//		out.write("文件写入成功！");
//		out.newLine();
//		out.flush();
		
		//释放资源
		ss.close();
		s.close();
		bw.close();
//		out.close();
	}
}
