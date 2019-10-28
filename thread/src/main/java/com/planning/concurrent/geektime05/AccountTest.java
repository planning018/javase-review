package com.planning.concurrent.geektime05;

/**
 * @author planning
 * @create 2019-10-28 15:53
 **/
public class AccountTest {

    public static void main(String[] args) throws InterruptedException {
        testAccount();
    }

    private static void testAccount() throws InterruptedException {
        Account a = new Account();
        a.initBalance();

        Thread thread1 = new Thread(()->{
            a.withdraw(100);
            a.updatePassword("123");
        });

        Thread thread2 = new Thread(()->{
            a.withdraw(100);
            a.updatePassword("234");
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("A balance result is : " + a.getBalance());
        System.out.println("A balance result is : " + a.getPassword());
    }
}