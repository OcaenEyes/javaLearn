import java.io.*;
public class SerializorTest {
    //序列化

    public static void main(String[] args) {
        Dog wangwang = new Dog();
        wangwang.name = "biubiu";
        wangwang.age = 10;
        wangwang.color = "white";
        try {
            FileOutputStream fileOut = new FileOutputStream("/Users/gaozhiyong/Documents/GitHub/javaLearn/tmp/test/dog.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wangwang);
            out.close();
            System.out.println("序列化解析器已经保存成功");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}