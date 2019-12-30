//import jdk.internal.util.xml.impl.Input;

import java.net.*;
import java.io.*;

public class SocketClientDemo {
    public static void main(String[] args) {
        String serverName =  "localhost";
        int port = 6606;
        try {
            System.out.println("连接到主机:" + serverName + ",端口号：" + port);
            Socket client = new Socket(serverName,port);
            System.out.println("远程主机的地址："+ client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(outToServer);

            dataOut.writeUTF("您好,来自" + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream dataIn = new DataInputStream(inFromServer);
            System.out.println("服务器响应："+ dataIn.readUTF());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
