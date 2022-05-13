package com.gzy.create.withrunnable;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-13 21:59
 */

/**
 * 创建多线程的方式二：实现runnable接口
 * 1、创建一个实现了Runnable接口的类
 * 2、实现类去实现Runnable中的抽象方法 : run()
 * 3、创建实现类的对象
 * 4、将此对象作为参数传入Thread类的构造器中， 创建Thread类的对象
 * 5、通过Thread的对象，调用start()
 */
class RunnableThread01_1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}


public class ThreadWithRunnable01 {
    public static void main(String[] args) {
        RunnableThread01_1 runnableThread01_1 = new RunnableThread01_1();
        Thread thread01 = new Thread(runnableThread01_1);
        // 通过Thread类对象调用start() 1.启动线程 2.调用当前线程的run() --> 调用Runnable类型的target的run()
        thread01.start();

        Thread thread02 = new Thread(runnableThread01_1);
        // 通过Thread类对象调用start() 1.启动线程 2.调用当前线程的run() --> 调用Runnable类型的target的run()
        thread02.start();


    }
}
