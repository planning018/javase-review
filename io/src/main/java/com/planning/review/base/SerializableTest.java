package com.planning.review.base;

import java.io.*;

/**
 * @Author: planning
 * @Date: 2019/1/10 10:16
 */
public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        A a1 = new A(123, "ABC");
        String objectFile = "SerializableFile";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        A a2 = (A) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("反序列化 A 的值为：" + a2);

    }

    private static class A implements Serializable{

        private int x;
        private String y;

        public A(int x, String y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = " + x + "  " + "y = " + y;
        }
    }

}