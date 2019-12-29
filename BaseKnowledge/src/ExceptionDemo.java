import java.lang.Exception;

public class ExceptionDemo {
    /*
        三类异常
        - 检查性异常：最具代表的检查性异常是用户错误或问题引起的异常，这是程序员无法预见的。例如要打开一个不存在文件时，一个异常就发生了，这些异常在编译时不能被简单地忽略。
        - 运行时异常： 运行时异常是可能被程序员避免的异常。与检查性异常相反，运行时异常可以在编译时被忽略。
        - 错误： 错误不是异常，而是脱离程序员控制的问题。错误在代码中通常被忽略。例如，当栈溢出时，一个错误就发生了，它们在编译也检查不到的。
     */

    /*
       内置异常类
          非检查性异常
            异常	                            描述
            ArithmeticException	            当出现异常的运算条件时，抛出此异常。例如，一个整数"除以零"时，抛出此类的一个实例。
            ArrayIndexOutOfBoundsException	用非法索引访问数组时抛出的异常。如果索引为负或大于等于数组大小，则该索引为非法索引。
            ArrayStoreException	            试图将错误类型的对象存储到一个对象数组时抛出的异常。
            ClassCastException	            当试图将对象强制转换为不是实例的子类时，抛出该异常。
            IllegalArgumentException	    抛出的异常表明向方法传递了一个不合法或不正确的参数。
            IllegalMonitorStateException	抛出的异常表明某一线程已经试图等待对象的监视器，或者试图通知其他正在等待对象的监视器而本身没有指定监视器的线程。
            IllegalStateException	        在非法或不适当的时间调用方法时产生的信号。换句话说，即 Java 环境或 Java 应用程序没有处于请求操作所要求的适当状态下。
            IllegalThreadStateException	    线程没有处于请求操作所要求的适当状态时抛出的异常。
            IndexOutOfBoundsException	    指示某排序索引（例如对数组、字符串或向量的排序）超出范围时抛出。
            NegativeArraySizeException	    如果应用程序试图创建大小为负的数组，则抛出该异常。
            NullPointerException	        当应用程序试图在需要对象的地方使用 null 时，抛出该异常
            NumberFormatException	        当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常。
            SecurityException	            由安全管理器抛出的异常，指示存在安全侵犯。
            StringIndexOutOfBoundsException	此异常由 String 方法抛出，指示索引或者为负，或者超出字符串的大小。
            UnsupportedOperationException	当不支持请求的操作时，抛出该异常。

         检查性异常类
            异常	                            描述
            ClassNotFoundException	        应用程序试图加载类时，找不到相应的类，抛出该异常。
            CloneNotSupportedException	    当调用 Object 类中的 clone 方法克隆对象，但该对象的类无法实现 Cloneable 接口时，抛出该异常。
            IllegalAccessException	        拒绝访问一个类的时候，抛出该异常。
            InstantiationException	        当试图使用 Class 类中的 newInstance 方法创建一个类的实例，而指定的类对象因为是一个接口或是一个抽象类而无法实例化时，抛出该异常。
            InterruptedException	        一个线程被另一个线程中断，抛出该异常。
            NoSuchFieldException	        请求的变量不存在
            NoSuchMethodException	        请求的方法不存在
     */
    /*
        throws/throw 关键字

        finally 关键字
          finally 关键字用来创建在 try 代码块后面执行的代码块。
          无论是否发生异常，finally 代码块中的代码总会被执行。
          在 finally 代码块中，可以运行清理类型等收尾善后性质的语句
            try{
                // 程序代码
            }catch(异常类型1 异常的变量名1){
                // 程序代码
            }catch(异常类型2 异常的变量名2){
                // 程序代码
            }finally{
                // 程序代码
            }

     */

    public void getExceptiondemo(){
        //捕获异常
        /*
                try
                {
                    // 程序代码
                }catch(ExceptionName e1)
                {
                    //Catch 块
                }
         */

        // 多重捕获异常
        /*
                try{
                    // 程序代码
                }catch(异常类型1 异常的变量名1){
                    // 程序代码
                }catch(异常类型2 异常的变量名2){
                    // 程序代码
                }catch(异常类型2 异常的变量名2){
                    // 程序代码
                }
         */
        try {
            int[] a = new int[2];
            System.out.println(a[3]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown" +e);
        }
        System.out.println("out of the block");
    }



    public static void main(String[] args){
        ExceptionDemo exp = new ExceptionDemo();
        exp.getExceptiondemo();
    }
}
