package com.planning.review.nio.demo;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yxc
 * @since 2020-08-04 20:16
 **/
public class ReadAndShow {

    public static void main(String[] args) throws Exception{
        FileInputStream fin = new FileInputStream("readAndShow.txt");
        FileChannel fcin = fin.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
    }
}