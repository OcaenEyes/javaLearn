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

    public void ReadFileDemo() throws IOException{
        //FileInputStream 从文件读取数据
        //  File f = new File("C:/java/hello");
        //  InputStream out = new FileInputStream(f);
        /*
            序号	方法及描述
            1	public void close() throws IOException{}
                关闭此文件输入流并释放与此流有关的所有系统资源。抛出IOException异常。
            2	protected void finalize()throws IOException {}
                这个方法清除与该文件的连接。确保在不再引用文件输入流时调用其 close 方法。抛出IOException异常。
            3	public int read(int r)throws IOException{}
                这个方法从 InputStream 对象读取指定字节的数据。返回为整数值。返回下一字节数据，如果已经到结尾则返回-1。
            4	public int read(byte[] r) throws IOException{}
                这个方法从输入流读取r.length长度的字节。返回读取的字节数。如果是文件结尾则返回-1。
            5	public int available() throws IOException{}
                返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取的字节数。返回一个整数值。
         */
        System.out.println("打印输出读取文件demo");
        InputStream is1 = new FileInputStream("test.txt");
        int size = is1.available();
        for (int i=0;i<size;i++) {
            System.out.println((char) is1.read());

        }
    }

    public void WriteFileDemo() throws IOException {
        //FileOutputStream 创建一个文件向文件中写数据
        //  File f = new File("C:/java/hello");
        //  OutputStream f = new FileOutputStream(f);
        /*
            序号	方法及描述
            1	public void close() throws IOException{}
                关闭此文件输入流并释放与此流有关的所有系统资源。抛出IOException异常。
            2	protected void finalize()throws IOException {}
                这个方法清除与该文件的连接。确保在不再引用文件输入流时调用其 close 方法。抛出IOException异常。
            3	public void write(int w)throws IOException{}
                这个方法把指定的字节写到输出流中。
            4	public void write(byte[] w)
                把指定数组中w.length长度的字节写到OutputStream中。
         */
        System.out.println("打印输出写入文件demo");
        byte bWrite[] = {11,21,3,38,5};
        OutputStream os1 = new FileOutputStream("test.txt");
        for (int i=0;i<bWrite.length;i++){
            os1.write(bWrite[i]);
        }
        os1.close();
    }

    public void CreateDirs(){
        //文件和I/O ，目录
        /*
            File类
            - mkdir( )方法创建一个文件夹，成功则返回true，失败则返回false。失败表明File对象指定的路径已经存在，或者由于整个路径还不存在，该文件夹不能被创建。
            - mkdirs()方法创建一个文件夹和它的所有父文件夹。
        */
        String dirname = "/Users/gaozhiyong/Documents/GitHub/javaLearn/tmp/testdir/test";
        File dir1 = new File(dirname);
        //   创建目录
        dir1.mkdirs();

    }

    public void ReadDirs(){
        /*
            一个目录其实就是一个 File 对象，它包含其他文件和文件夹。
            如果创建一个 File 对象并且它是一个目录，那么调用 isDirectory() 方法会返回 true。
            可以通过调用该对象上的 list() 方法，来提取它包含的文件和文件夹的列表。
         */
        String dirname = "/Users/gaozhiyong/Documents/GitHub/javaLearn";
        File dir2 = new File(dirname);
        if (dir2.isDirectory()){
            System.out.println("目录"+ dirname);
            String[] s1 = dir2.list();
            for (int i=0;i<s1.length;i++){
                File f = new File(dirname + '/' + s1[i]);
                if (f.isDirectory()){
                    System.out.println(s1[i] + "是一个目录");
                }else {
                    System.out.println(s1[i] + "是一个文件");
                }
            }
        }else {
            System.out.println(dirname +"不是一个目录");
        }
    }

    public void DeleteDirs(){
        //删除文件/目录
        /*
            删除文件可以使用 java.io.File.delete() 方法
            当删除某一目录时，必须保证该目录下没有其他文件才能正确删除，否则将删除失败
         */
        String dirname = "/Users/gaozhiyong/Documents/GitHub/javaLearn/tmp/testdir";
        File dir3 = new File(dirname);
        File[] files = dir3.listFiles();
        if (files != null){
            for (File f: files){
                if (!f.isDirectory()){
                    f.delete();
                }
            }
        }
        dir3.delete();
        System.out.println("删除成功");
    }


    public static void main(String[] args) throws IOException {
        StreamFileIODemo s = new StreamFileIODemo();
//        s.printChar();
//        s.printStr();
//        s.WriteFileDemo();
//        s.CreateDirs();
//        s.ReadDirs();
        s.DeleteDirs();
    }
}
