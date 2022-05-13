package com.gzy.use.withthread;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 00:49
 */

/**
 * 存在线程安全问题：卖错票，卖重票
 * 使用同步方法块解决继承类的线程安全问题
 */
class Window2 extends Thread {
    private static int ticket = 100;
    private static Object object = new Object();

    @Override
    public void run() {
        while (ticket>0){
            show();
        }
    }

    public Window2(String name) {
        super(name);
    }

    private static synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票票号为：" + ticket);
            ticket--;
        }
    }
}

public class ThreadUse03 {
    public static void main(String[] args) {
        Window2 w1 = new Window2("窗口一");
        Window2 w2 = new Window2("窗口二");
        Window2 w3 = new Window2("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}
