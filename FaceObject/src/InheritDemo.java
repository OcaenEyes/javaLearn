public class InheritDemo {

    /*
        类的继承,降低代码重复，提取公共部分组成父类
            class 父类 {
            }

            class 子类 extends 父类 {
            }
     */
    private String name;
    private int Age;

    public InheritDemo(String aName, int age) {
        //初始化动物
        name = aName;
        Age = age;
    }

    public void eat() {
        //定义 吃东西的方法
        System.out.println("饿了");
    }

    public void sleep() {
        // 定义 睡觉的方法
        System.out.println("睡了");
    }
}

class Dog extends InheritDemo{
    public Dog(String aName,int age){
        super(aName,age);
    }
}




