package com.gzy.use.withthread;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-13 21:02
 */

/**
 * 线程中的常用方法
 * 1、start()启动当前线程；调用当前线程的run()
 * 2、run() 通常需重写Thread类中的此方法，将创建的线程 需要执行的操作 声明在此方法中
 * 3、currentThread() 静态方法，返回执行当前代码的线程
 * 4、getName() 获取当前线程的名字
 * 5、setName() 设置当前线程的名字
 * 6、yield() 释放当前CPU的执行权（让步）
 * 7、join() 在线程a中调用线程b的join(),此时线程a进入阻塞状态，直到线程b完全执行完成以后，c才会结束阻塞状态
 * 8、stop() 已过时，当执行此方法时，强制结束当前线程
 * 9、sleep(long milltime) 线程睡醒X毫秒等待，等待期间线程为阻塞状态
 * 10、isAlive() 判断线程是否存活
 * <p>
 * 线程错误时
 * 1、try/catch InterruptedException
 * 2、throws InterruptedException
 * <p>
 * <p>
 * 线程优先级
 * 1、MAX_PRIORITY:10
 * 2、MIN_PRIORITY:1
 * 3、NORM_PRIORITY:5
 * <p>
 * 1、getPriority() 获取当前线程优先级
 * 2、setPriority(int p) 设置当前线程优先级 (从概率上高优先级的线程，可能会先执行)
 */
class MyThreadUse01_1 extends Thread {
    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
            if (i % 20 == 0) {
                yield();
//                this.yield();
            }
        }
    }
}

class MyThreadUse01_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    public MyThreadUse01_2(String name) {
        super(name);
    }
}

class MyThreadUse01_3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    public MyThreadUse01_3(String name) {
        super(name);
    }
}


public class ThreadUse01 {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");

        MyThreadUse01_1 myThreadUse01_1 = new MyThreadUse01_1();
        myThreadUse01_1.setName("线程一");
        myThreadUse01_1.setPriority(9);
        myThreadUse01_1.start();

        MyThreadUse01_2 myThreadUse01_2 = new MyThreadUse01_2("线程二");
        myThreadUse01_2.start();


        MyThreadUse01_3 myThreadUse01_3 = new MyThreadUse01_3("线程三");
        myThreadUse01_3.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            if (i == 20) {
                try {
                    myThreadUse01_3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
