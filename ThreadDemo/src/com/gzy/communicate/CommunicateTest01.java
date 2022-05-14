package com.gzy.communicate;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 12:12
 */

/**
 * 线程通信案例：使用两个线程打印1-100， 线程一和线程二交替打印
 * 1.wait() 执行此方法，当前线程进入阻塞状态，并释放同步监视器
 * 2.notify() 执行此方法，会唤醒被wait的一个线程， 如果有多个被wait,则唤醒优先级高的线程
 * 3.notifyALl() 执行此方法，唤醒所有被wait的线程
 *
 * 补充说明
 * 1.wait() notify() notifyALl() 必须使用在synchronized的同步方法 或同步代码块中
 * 2.wait() notify() notifyALl() 的调用者，必须是同步方法 或同步代码块 中的 同步监视器
 * 3.wait() notify() notifyALl() 定义在 java.lang.Object类中
 *
 *
 * sleep() 和wait()的异同
 * 相同点：执行后会使当前线程进入阻塞状态
 * 不同点：
 *      1) 声明位置不同：Thread类中声明sleep(), Object类中声明wait()
 *      2) 调用要求不同：sleep()可以在任何需要的场景使用，wait()只能应用在 同步方法或同步代码块
 *      3) 关于是否释放同步监视器：如果两个方法都使用在同步代码块/同步方法中，sleep()不会释放锁，wait()会释放锁
 */
class MyNumber implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {
            //synchronized 同步代码块
//            synchronized (this) {
//                if (num < 100) {
//                    System.out.println(Thread.currentThread().getName() + ":" + num);
//                    num++;
//                } else {
//                    break;
//                }
//            }
            // synchronized 同步代码块+ wait()+ notifyAll()
            synchronized (this) {
                notifyAll(); //唤醒线程
                if (num < 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }

        }
    }
}

public class CommunicateTest01 {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        Thread thread1 = new Thread(myNumber);
        Thread thread2 = new Thread(myNumber);
        thread1.setName("线程一");
        thread2.setName("线程二");
        thread1.start();
        thread2.start();

    }
}
