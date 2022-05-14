package com.gzy.create.withcallable;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 13:03
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方法三：实现callable接口
 * 1.call() 有返回值
 * 2.call() 可以抛出异常,被外部操作捕获
 * 3.Callable 支持泛型
 */
class ThreadCall01_01 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

public class CallableThread01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadCall01_01 threadCall01_01 = new ThreadCall01_01();

        FutureTask futureTask = new FutureTask(threadCall01_01);
        // 将futureTask传入Thread,创建新的线程
        Thread thread = new Thread(futureTask);
        thread.start();
        // get() 返回值，即为FutureTask构造器参数Callable实现类重写的call()的返回值
        Object o = futureTask.get();
        System.out.println("总和为：" + o);

    }
}
