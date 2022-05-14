package com.gzy.use;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 01:11
 */
public class ThreadSafetySingletonPattern {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    private static Bank getInstance() {
        // 方式一： 效率稍差
//        synchronized (Bank.class){
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        // 方式二
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
