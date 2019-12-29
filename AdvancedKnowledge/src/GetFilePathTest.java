import java.io.File;
import java.io.IOException;

public class GetFilePathTest {
    public static void main(String[] args){
        //获取当前文件目录
        File f = new File(".");
        String path = null;
        try {
            path = f.getCanonicalPath();
            System.out.println(path);
        } catch (IOException e) {
            System.out.println(e);
        }
        path = path + "/tmp/test";
        File file = new File(path);
        System.out.println(path);
        if (!file.exists() && !file.isDirectory()) {
            System.out.println("不存在");
            file.mkdirs();
        }else {
            System.out.println("目录存在");
        }

    }
}
