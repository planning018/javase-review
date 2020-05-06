package com.planning.concurrent.geektime;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author planning
 * @create 2019-10-28 15:53
 **/
public class AccountTest {

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(4, 10, 1000,
            TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(16), new ThreadFactoryBuilder().setNameFormat("Accout-task-thread-pool-%d").build());

    @Test
    public void testMain() {
        for(int i = 0; i < 5000; i ++){
            testAccount();
        }
    }

    /**
     * 采用 细粒度锁 这种方式 password 的值会存在并发问题
     * todo 是使用方式不对吗？留待后续观察?
     */
    private void testAccount() {
        //Account a = new Account();
        Account2 a = new Account2();
        a.initBalance();

        Thread thread1 = new Thread(()->{
            a.withdraw(100);
            a.updatePassword("123");
        });

        Thread thread2 = new Thread(()->{
            a.withdraw(100);
            a.updatePassword("234");
        });

/*        EXECUTOR.execute(() -> {
            a.withdraw(100);
            a.updatePassword("123");
        });
        EXECUTOR.execute(() -> {
            a.withdraw(100);
            a.updatePassword("234");
        });*/

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("balance result is : " + a.getBalance());
        System.out.println("balance password is : " + a.getPassword());
    }


    class Account {

        /**
         * 锁：保护账户余额
         */
        private final Object balLock = new Object();

        /**
         * 账户余额
         */
        private Integer balance;

        /**
         * 锁： 保护账户密码
         */
        private final Object pwLock = new Object();

        /**
         * 账户密码
         */
        private String password;

        /**
         * 取款
         * @param amt
         */
        void withdraw(Integer amt){
            synchronized (balLock){
                if (this.balance > amt){
                    this.balance -= amt;
                }
            }
        }

        void initBalance(){
            synchronized (balLock){
                this.balance = 500;
            }
        }

        /**
         * 查看余额
         * @return
         */
        Integer getBalance(){
            synchronized (balLock){
                return this.balance;
            }
        }

        void updatePassword(String pw){
            synchronized (pwLock){
                this.password = pw;
            }
        }

        String getPassword(){
            synchronized (pwLock){
                return password;
            }
        }
    }

    class Account2 {

        /**
         * 账户余额
         */
        private Integer balance;

        /**
         * 账户密码
         */
        private String password;

        /**
         * 取款
         * @param amt
         */
        void withdraw(Integer amt){
            synchronized (Account2.class){
                if (this.balance > amt){
                    this.balance -= amt;
                }
            }
        }

        void initBalance(){
            synchronized (Account2.class){
                this.balance = 500;
            }
        }

        /**
         * 查看余额
         * @return
         */
        Integer getBalance(){
            synchronized (Account2.class){
                return this.balance;
            }
        }

        void updatePassword(String pw){
            synchronized (Account2.class){
                this.password = pw;
            }
        }

        String getPassword(){
            synchronized (Account2.class){
                return password;
            }
        }
    }
}

