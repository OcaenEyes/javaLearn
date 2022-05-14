package com.gzy.practice;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 12:33
 */

/**
 * 产品的生产者消费者问题
 * 分析：
 * 1.生产者线程、消费者线程
 * 2.有共享数据，店员/产品
 * 3.需要考虑线程安全问题
 * 4.同步机制
 * 5.涉及到线程通信
 */

class Product {
    private int amt;

    private Product(int amt) {
        this.amt = amt;
    }

    private static class ProductInstance {
        private final static Product INSTANCE = new Product(0);
    }

    public static Product getInstance() {
        return ProductInstance.INSTANCE;
    }

    // 生产
    public synchronized void produceP() {
        if (amt < 20) {
            amt++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第:" + amt + "件");
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费
    public synchronized void consumeP() {
        if (amt > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第:" + amt + "件");
            amt--;
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            product.produceP();
        }
    }
}

class Consumer implements Runnable {
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            product.consumeP();
        }
    }
}


public class ProducerConsumer {
    public static void main(String[] args) {
        Product product = Product.getInstance();
        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.setName("生产者");
        thread2.setName("消费者");

        thread1.start();
        thread2.start();


    }
}
