package com.planning.review.oio.net08;

import java.io.*;
import java.net.Socket;

public class ClientDemo {

	public static void main(String[] args) throws IOException{
		//创建发送端socket对象
		Socket s = new Socket("192.168.0.104",10010); 
		
		//封装键盘录入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//把通道内的输出流封装成字符流
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		String line = null;
		while((line = br.readLine())!= null){
			if("over".equals(line)){
				break;
			}
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//释放资源
		s.close();
	}
}
