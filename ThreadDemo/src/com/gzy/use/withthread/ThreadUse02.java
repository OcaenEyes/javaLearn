package com.gzy.use.withthread;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 00:22
 */

/**
 * 存在线程安全问题：卖错票，卖重票
 * 使用同步代码块解决继承类的线程安全问题
 */
class Window extends Thread {
    private static int ticket = 100;
    private static Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (ticket > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票-票号:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }

    public Window(String name) {
        super(name);
    }
}

public class ThreadUse02 {
    public static void main(String[] args) {
        Window w1 = new Window("窗口一");
        Window w2 = new Window("窗口二");
        Window w3 = new Window("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}
