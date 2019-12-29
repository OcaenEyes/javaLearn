import java.net.*;
import java.io.*;

public class SocketServerDemo extends Thread {
    private ServerSocket serverSocket;

    //  构造方法
    public SocketServerDemo(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(5000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                System.out.println("客户端的地址：" + server.getRemoteSocketAddress());
                DataInputStream dataIn = new DataInputStream(server.getInputStream());
                System.out.println(dataIn.readUTF());
                DataOutputStream dataOut = new DataOutputStream(server.getOutputStream());
                dataOut.writeUTF("谢谢连接我" + server.getLocalSocketAddress());
                server.close();
            } catch (SocketTimeoutException s) {
                s.printStackTrace();
                System.out.println("Socket time out");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = 6606;
        try {
            Thread t = new SocketServerDemo(port);
            t.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
