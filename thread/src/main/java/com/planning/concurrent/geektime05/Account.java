package com.planning.concurrent.geektime05;

/**
 * Account Class
 *
 * @author planning
 * @create 2019-10-28 15:49
 **/
public class Account {

    // 锁：保护账户余额
    private final Object balLock = new Object();

    // 账户余额
    private Integer balance;

    // 锁： 保护账户密码
    private final Object pwlock = new Object();

    // 账户密码
    private String password;

    // 取款
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

    // 查看余额
    Integer getBalance(){
        synchronized (balLock){
            return this.balance;
        }
    }

    void updatePassword(String pw){
        synchronized (pwlock){
            this.password = pw;
        }
    }

    String getPassword(){
        synchronized (pwlock){
            return this.password;
        }
    }
}