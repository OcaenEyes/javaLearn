import java.util.Scanner;

public class ScannerDemo {
    //Scanner类 获取用户的输入
    /*
        next() 与 nextLine() 区别
        next():
            1、一定要读取到有效字符后才可以结束输入。
            2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
            3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
        next() 不能得到带有空格的字符串。
        nextLine()：
            1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
            2、可以获得空白。
        如果要输入 int 或 float 类型的数据，在 Scanner 类中也有支持，但是在输入之前最好先使用 hasNextXxx() 方法进行验证，再使用 nextXxx() 来读取：
     */

    public void NextDemo() {
        //从键盘接收数据
        Scanner scan1 = new Scanner(System.in);

        //next方式接收字符串
        System.out.println("next方式接收：");
        //判断是否还有输入
        if (scan1.hasNext()) {
            String str1 = scan1.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan1.close();

    }

    public void NextLineDemo() {
        //从键盘接收数据
        Scanner scan2 = new Scanner(System.in);

        //nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        //判断是否还有输入
        if (scan2.hasNext()) {
            String str2 = scan2.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan2.close();

    }

    public static void main(String[] args) {
        ScannerDemo s = new ScannerDemo();
//        s.NextDemo();
        s.NextLineDemo();

    }
}
