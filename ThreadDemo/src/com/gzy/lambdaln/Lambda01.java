package com.gzy.lambdaln;

/**
 * @version 0.0.1
 * @author： OCEAN.GZY
 * @date： 2022-05-14 13:58
 */
public class Lambda01 {

    public static void main(String[] args) {
        // 测试一
        Runnable like = () -> {
            System.out.println("这是一句lambd尝试");
        };
        like.run();

        // 测试二
        Like like1 = () -> {
            System.out.println("这是第二句lambda");
        };
        like1.like();

        // 测试三
        Like like2 = () ->
                System.out.println("这是第三句lambda");
        like2.like();

    }
}

interface Like {
    void like();
}
