package com.gzy;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 01:27
 */

/**
 * 1.死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，都早等待对方放弃自己需要的同步资源， 造成了死锁
 * 2.说明：
 * 1）出现死锁时，不会出现异常，也不会提示，只是所有线程处于阻塞状态，无法继续
 * 2）使用同步时候要避免死锁
 */

public class DeadLock {
    public static void main(String[] args) {
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();

        new Thread() {
            @Override
            public void run() {
                synchronized (stringBuffer1) {
                    stringBuffer1.append("a");
                    stringBuffer2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (stringBuffer2) {
                        stringBuffer1.append("b");
                        stringBuffer2.append("2");
                        System.out.println(stringBuffer1);
                        System.out.println(stringBuffer2);
                    }
                }
            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (stringBuffer2) {
                    stringBuffer1.append("c");
                    stringBuffer2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (stringBuffer1) {
                        stringBuffer1.append("d");
                        stringBuffer2.append("4");
                        System.out.println(stringBuffer1);
                        System.out.println(stringBuffer2);
                    }
                }
            }
        }
        ).start();
    }
}
