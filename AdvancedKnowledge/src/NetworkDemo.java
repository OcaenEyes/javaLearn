import java.net.*;
import java.io.*;
/*
    java.net 包中提供了两种常见的网络协议的支持：
        TCP：TCP 是传输控制协议的缩写，它保障了两个应用程序之间的可靠通信。通常用于互联网协议，被称 TCP / IP。
        UDP：UDP 是用户数据报协议的缩写，一个无连接的协议。提供了应用程序之间要发送的数据的数据包。
 */
public class NetworkDemo {
            /*
            服务器实例化一个 ServerSocket 对象，表示通过服务器上的端口通信。
            服务器调用 ServerSocket 类的 accept() 方法，该方法将一直等待，直到客户端连接到服务器上给定的端口。
            服务器正在等待时，一个客户端实例化一个 Socket 对象，指定服务器名称和端口号来请求连接。
            Socket 类的构造函数试图将客户端连接到指定的服务器和端口号。如果通信被建立，则在客户端创建一个 Socket 对象能够与服务器进行通信。
            在服务器端，accept() 方法返回服务器上一个新的 socket 引用，该 socket 连接到客户端的 socket。
            连接建立后，通过使用 I/O 流在进行通信，每一个socket都有一个输出流和一个输入流，客户端的输出流连接到服务器端的输入流，而客户端的输入流连接到服务器端的输出流。
         */

    // ServerSocket类
    // 服务器应用程序通过使用 java.net.ServerSocket 类以获取一个端口,并且侦听客户端请求
        /*
            四种构造方法
            序号	方法描述
            1	public ServerSocket(int port) throws IOException
                创建绑定到特定端口的服务器套接字。
            2	public ServerSocket(int port, int backlog) throws IOException
                利用指定的 backlog 创建服务器套接字并将其绑定到指定的本地端口号。
            3	public ServerSocket(int port, int backlog, InetAddress address) throws IOException
                使用指定的端口、侦听 backlog 和要绑定到的本地 IP 地址创建服务器。
            4	public ServerSocket() throws IOException
                创建非绑定服务器套接字。

            常用方法
            序号	方法描述
            1	public int getLocalPort()
                返回此套接字在其上侦听的端口。
            2	public Socket accept() throws IOException
                侦听并接受到此套接字的连接。
            3	public void setSoTimeout(int timeout)
                通过指定超时值启用/禁用 SO_TIMEOUT，以毫秒为单位。
            4	public void bind(SocketAddress host, int backlog)
                将 ServerSocket 绑定到特定地址（IP 地址和端口号）。

         */

    //Socket 类
    //java.net.Socket 类代表客户端和服务器都用来互相沟通的套接字
        /*
            五种构造方法
            序号	方法描述
            1	public Socket(String host, int port) throws UnknownHostException, IOException.
                创建一个流套接字并将其连接到指定主机上的指定端口号。
            2	public Socket(InetAddress host, int port) throws IOException
                创建一个流套接字并将其连接到指定 IP 地址的指定端口号。
            3	public Socket(String host, int port, InetAddress localAddress, int localPort) throws IOException.
                创建一个套接字并将其连接到指定远程主机上的指定远程端口。
            4	public Socket(InetAddress host, int port, InetAddress localAddress, int localPort) throws IOException.
                创建一个套接字并将其连接到指定远程地址上的指定远程端口。
            5	public Socket()
                通过系统默认类型的 SocketImpl 创建未连接套接字

            常用方法
            序号	方法描述
            1	public void connect(SocketAddress host, int timeout) throws IOException
                将此套接字连接到服务器，并指定一个超时值。
            2	public InetAddress getInetAddress()
                返回套接字连接的地址。
            3	public int getPort()
                返回此套接字连接到的远程端口。
            4	public int getLocalPort()
                返回此套接字绑定到的本地端口。
            5	public SocketAddress getRemoteSocketAddress()
                返回此套接字连接的端点的地址，如果未连接则返回 null。
            6	public InputStream getInputStream() throws IOException
                返回此套接字的输入流。
            7	public OutputStream getOutputStream() throws IOException
                返回此套接字的输出流。
            8	public void close() throws IOException
                关闭此套接字。

         */


    // InetAdress 类的方法  表示互联网协议（IP）地址
        /*
            序号	方法描述
            1	static InetAddress getByAddress(byte[] addr)
                在给定原始 IP 地址的情况下，返回 InetAddress 对象。
            2	static InetAddress getByAddress(String host, byte[] addr)
                根据提供的主机名和 IP 地址创建 InetAddress。
            3	static InetAddress getByName(String host)
                在给定主机名的情况下确定主机的 IP 地址。
            4	String getHostAddress()
                返回 IP 地址字符串（以文本表现形式）。
            5	String getHostName()
                获取此 IP 地址的主机名。
            6	static InetAddress getLocalHost()
                返回本地主机。
            7	String toString()
                将此 IP 地址转换为 String。
         */
}
