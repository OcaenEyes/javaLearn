import java.io.*;

public class StreamFileIODemo {
    public void printChar() throws IOException {
        //使用BufferedReader从控制台读取输入
        char c;
        //使用System.in 创建BufferedReader
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符，按Q键退出");
        do {
            //read() 读取字符
            c = (char) br1.read();
            System.out.println(c);
        } while (c != 'Q');
    }

    public void printStr() throws IOException{
        String str1;
        //使用System.in 创建BufferedReader
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符 'end' 退出");
        do {
            //readLine() 读取字符串
            str1 = br1.readLine();
            System.out.println(str1);
        } while (!str1.equals("end"));

    }

    public void ReadFileDemo(){
        //FileInputStream 

    }

    public static void main(String[] args) throws IOException {
        StreamFileIODemo s = new StreamFileIODemo();
        s.printChar();
        s.printStr();
    }
}
