package com.planning.review.base;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class IO_5 {

	/**
	 * ArrayList<T> to File
	 * @throws IOException
	 */
	@Test
	public void test17() throws IOException{
		//数据源
		ArrayList<String> array = new ArrayList<String>();
		array.add("zhangsan");
		array.add("lisi");
		array.add("wangwu");
		
		//目的地
		BufferedWriter bw = new BufferedWriter(new FileWriter("./test/test17.txt"));
		for (String str : array) {
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
	
	/**
	 * File TO ArrayList<T>
	 * @throws IOException
	 */
	@Test
	public void test18() throws IOException{
		//数据源
		BufferedReader br = new BufferedReader(new FileReader("./test/test17.txt"));
		//目的地
		ArrayList<String> array = new ArrayList<String>();
		
		String line = null;
		while((line = br.readLine())!=null){
			array.add(line);
		}
		
		br.close();
		//遍历集合
		for (String str : array) {
			System.out.println(str);
		}
	}
	
	
	/**
	 * 已有目录名单，随机点名
	 * @throws IOException
	 */
	@Test
	public void test19() throws IOException{
		//数据源
		BufferedReader br = new BufferedReader(new FileReader("./test/test17.txt"));
		ArrayList<String> array = new ArrayList<String>();
		
		String line = null;
		while((line = br.readLine())!= null){
			array.add(line);
		}
		
		//随机点名
		Random random = new Random();
		int num = random.nextInt(array.size());
		System.out.println("这个幸运的人是：" + array.get(num));
	}
	
	/**
	 * 将test文件夹下的内容 全部 复制到 copyTest文件夹下
	 * @throws IOException
	 */
	@Test
	public void test20() throws IOException{
		//封装目标文件
		File file = new File("./test");
		if(!file.exists()){
			System.out.println("文件夹不存在!");
			System.exit(0);
		}
		//获取目标文件夹下的所有文件
		File[] fileAry = file.listFiles();
		
		//封装目的文件
		File destFolder = new File("./testCopy");
		if(!destFolder.exists()){
			destFolder.mkdir();
		}
		
		for (File srcFile : fileAry) {
			String name = srcFile.getName();
			File destFile = new File(destFolder,name);
			copy(srcFile,destFile);
		}
		
	}
	
	public void copy(File srcFile, File destFile) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		
		byte[] bys = new byte[1024];
		int len = 0;
		while((len = bis.read(bys))!=-1){
			bos.write(bys, 0, len);
		}
		
		bis.close();
		bos.close();
		
	}
		
}
