package com.planning.review.base;

import com.planning.review.base.bean.Person;
import org.junit.Test;

import java.io.*;


public class IO_6 {

	//实现 java.io.Serializable 接口以启用其序列号功能
	/**
	 * 序列化 ObjectOutputStream
	 *     ---  public final void writeObject(Object obj)
	 * @throws IOException
	 */
	@Test
	public void test21() throws IOException{
		//创建序列号对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./test/test21.txt"));
		Person p = new Person("linqingxia",23);
		oos.writeObject(p);
		oos.close();
	}
	
	/**
	 * 反序列号  ObjectInputStream 
	 *      ---  public final Object readObject()
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test22() throws IOException, ClassNotFoundException{
		ObjectInputStream ios = new ObjectInputStream(new FileInputStream("./test/test21.txt"));
		Object obj = ios.readObject();
		ios.close();
		System.out.println(obj.toString());
	}
}
