package com.gzy.use.withrunnable;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-13 23:05
 */

/**
 * 存在线程问题：卖了同一张票、卖了错票
 * 问题原因：当某个线程操作车票当过程中，尚未操作完成，其他线程参与进来也操作了车票
 * 解决方法：当线程a在操作ticket的时候，其他线程不能参与进来，直到线程a操作完成ticket,其他线程才可以参与进来
 *          （即使线程a出现阻塞，其他线程也需要等待）
 * java实现解决：同步机制，解决线程安全
 * 同步机制：好处：解决了线程安全问题
 *         局限性：操作同步代码时，只能有一个线程参与，其他线程等待，相当于单线程的过程，效率低
 * 方式一.同步代码块
 *      synchronized(同步监视器){
 *          // 需要被同步的代码
 *      }
 *      说明: 1.操作共享数据的代码，即为需要被同步的代码）
 *           2.共享数据：多个线程共同操作的变量，比如本问题中的ticket
 *           3.同步监视器：俗称锁，任何一个类对象都可以当作锁; 要求：多个线程必须要共用同一把锁
 *              补充：在implements Runnable中，可以使用this当做同步监视器
 *                   在extends Thread中，可以使用 类名.class当作同步监视器
 *
 * 方式二.同步方法
 *      如果操作数据的代码完整的声明在一个方法中，可以将此方法声明同步
 */

/**
 * 同步代码块-实现
 */
class RunnableThread02 implements Runnable {
    private int ticket = 150;
    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class ThreadRunnableUse01 {
    public static void main(String[] args) {
        RunnableThread02 runnableThread02 = new RunnableThread02();
        Thread window1 = new Thread(runnableThread02);
        Thread window2 = new Thread(runnableThread02);
        Thread window3 = new Thread(runnableThread02);
        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();
    }
}
