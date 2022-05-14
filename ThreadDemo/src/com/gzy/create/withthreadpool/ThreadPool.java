package com.gzy.create.withthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 13:32
 */

/**
 * 使用线程池创建线程
 * 1.corePoolSize
 * 2.maxnumPoolSize
 * 3.keepAliveTime
 */
class Num01_01 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        // 创建指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        // 设置线程池的属性
        service1.setCorePoolSize(6);
//        service1.setKeepAliveTime();
//        service1.setMaximumPoolSize();

        //  适用于 Runnable，指定运行对应的线程
        service1.execute(new Num01_01());
        //适用于Callable，指定运行对应的线程
//        service.submit();
        // 关闭线程池
        service.shutdown();
    }
}
