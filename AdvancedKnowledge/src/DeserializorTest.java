import java.io.*;

public class DeserializorTest {
    public static void main(String[] args){
        Dog dog = new Dog();
        try {
            FileInputStream fileIn = new FileInputStream("/Users/gaozhiyong/Documents/GitHub/javaLearn/tmp/test/dog.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            dog = (Dog) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException e) {
            e.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("类文件没有找到");
            c.printStackTrace();
            return;
        }
        System.out.println("name:"+dog.name);
        System.out.println("age:"+dog.age);
        System.out.println("color:"+dog.color);
    }
}
