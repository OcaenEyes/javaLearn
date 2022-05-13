package com.gzy.create.withthread; /**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-13 20:43
 */

/**
 * 创建两个线程，一个遍历100以内偶数，一个遍历100以内奇数
 */

class MyThread03_01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread03_02 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class Thread03 {
    public static void main(String[] args) {
        MyThread03_01 myThread03_01 = new MyThread03_01();
        MyThread03_02 myThread03_02 = new MyThread03_02();

        myThread03_01.start();
        myThread03_02.start();
    }
}
