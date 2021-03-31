package com.planning.review.nio.chat;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author yxc
 * @since 2020-08-08 17:49
 **/
public class TestChat {

    public static void main(String[] args) throws Exception {
        ChatClient chatClient = new ChatClient();

        new Thread(() -> {
            while (true){
                try {
                    chatClient.receiveMsg();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            chatClient.sendMsg(scanner.nextLine());
        }
    }
}