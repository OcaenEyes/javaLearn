package com.gzy.practice;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 09:57
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个储户，分别向一个空账户存3000元，每次存1000，存3次，每次存完打印账户余额
 * 分析：
 * 1.两个储户线程
 * 2.有共享数据，账户余额
 * 3.需要考虑线程安全问题
 * 4.同步机制
 */
class Money {
    private double balance;

    private Money() {
    }

    //    静态内部类
    private static class MoneyInstance {
        private static final Money INSTANCE = new Money();
    }

    public static Money getInstance() {
        return MoneyInstance.INSTANCE;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("存款成功，当前余额为：" + balance);
        }
    }
}

class People implements Runnable {
    private Money money = Money.getInstance();
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                reentrantLock.lock();
                money.deposit(1000);
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}

public class SaveMoney {
    public static void main(String[] args) {
        People people = new People();
        Thread thread1 = new Thread(people);
        Thread thread2 = new Thread(people);
        thread1.setName("甲");
        thread2.setName("乙");
        thread1.start();
        thread2.start();
    }
}
