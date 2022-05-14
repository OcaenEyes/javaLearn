package com.gzy;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 01:43
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁
 * synchronized 执行完同步代码后，自动释放同步监视器
 * Lock 需要手动的启动同步，手动结束同步
 * 优先级顺序：Lock > 同步代码块 >同步方法
 */
class Window implements Runnable {

    private int ticket = 100;

    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 调用lock()
                reentrantLock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 调用unlock()
                reentrantLock.unlock();
            }


        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }
}
