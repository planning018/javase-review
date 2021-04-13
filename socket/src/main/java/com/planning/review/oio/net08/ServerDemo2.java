package com.planning.review.oio.net08;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 在serverDemo的基础上修改，把客户端输出的内容写入文本 
 *
 */
public class ServerDemo2 {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(10010);
		Socket s = ss.accept();
		
		//封装客户端的输入流
		BufferedReader br  = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//创建输出流
		//复习：如何创建一个文件夹
		File file = new File("E:/WorkSpace/Eclipse/Net/net","net08");
		if(!file.exists()){
			file.mkdirs();
		}
		File newFile = new File(file.getAbsolutePath()+File.separator+"net08.txt");
		newFile.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
		
		String line = null;
		while((line = br.readLine())!= null){
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//释放资源
		bw.close();
		ss.close();
		s.close();
	}

}
