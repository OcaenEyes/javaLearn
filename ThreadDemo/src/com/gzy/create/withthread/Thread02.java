package com.gzy.create.withthread; /**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-13 20:12
 */

/**
 * 多线程的创建
 * 方式一：继承于Thread类
 * 1、创建一个继承于Thread类的子类
 * 2、重写Thread类的run()
 * 3、创建Thread类的子类的对象
 * 4、通过此对象调用start()
 */
class MyThreadDemo extends Thread {
    @Override
    public void run(){
        for (int i = 0; i <100 ; i++) {
            System.out.println(i);
        }
    }
}

public class Thread02 {
    public static void main(String[] args) {
        MyThreadDemo myThreadDemo = new MyThreadDemo();
        // ①启动当前线程②调用当前线程的run()
        myThreadDemo.start();
    }
}
