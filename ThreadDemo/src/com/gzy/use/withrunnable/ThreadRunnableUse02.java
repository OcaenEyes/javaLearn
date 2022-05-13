package com.gzy.use.withrunnable;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 00:44
 */

/**
 * 同步方法-实现
 */
class RunnableThread03 implements Runnable {
    private int ticket = 150;
    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() {
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

public class ThreadRunnableUse02 {
    public static void main(String[] args) {
        RunnableThread03 runnableThread03 = new RunnableThread03();
        Thread window1 = new Thread(runnableThread03);
        Thread window2 = new Thread(runnableThread03);
        Thread window3 = new Thread(runnableThread03);
        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();
    }
}
