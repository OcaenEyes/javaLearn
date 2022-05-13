package com.gzy.create.withthread;

public class DemoThread01 {
    public static void main(String[] args){
        MyThread mt = new MyThread();
        // 调用start方法，开启新线程，执行run
        mt.start();

        new MyThread().start();
    }
}
