public class ObjectAndClass {
    /*
    - 多态
    - 继承
    - 封装
    - 抽象
    - 类 ： 是一个模板，用来描述
    - 对象 ： 是类class的一个实例，具有状态和行为
    - 实例
    - 方法
    - 重载
     */

    //定义一个Dog类
    public static class Dog {
        //成员变量
        StringDemo color;
        int age;
        StringDemo name;

        //类方法
        void barking(){
            System.out.println("汪！汪！汪！");
        }

        void hungry(){
            System.out.println("好饿哦！");
        }

        void sleeping(){
            System.out.println("好困哦！");
        }

        void setAge(int age){
            this.age = age;
        }
    }

    public static void main(String[]args) {
        /*
            创建对象
            声明： 声明一个对象， 对象类型 和对象名称
            实例化： new创建
            初始化： 创建时调用构造方法生成
         */
        Dog dog = new Dog();
        dog.hungry();
        dog.barking();
        dog.sleeping();
        System.out.println(dog.age);
        dog.setAge(24);
        System.out.println(dog.age);

    }
}
