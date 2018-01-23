package base.网络编程.Socket_Demo.Demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wanglei on 2017/10/29.
 * 服务端
 * 创建ServerSocket(需要指定端口号)
 * 调用ServerSocket的accept()方法接收一个客户端请求，得到一个socket
 * 调用socket的getInputStream()和getOutputStream()方法获取和客户端相连的IO流
 * 输入流可以读取客户端输出流写出的数据
 * 输出流可以写出数据到客户端的输入流
 */
public class Server {
    public static void main(String[] args)
            throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("服务器已经启动，绑定端口12345");
        //接收客户端的请求
        Socket socket = server.accept();
        //获取客户端输入流
        InputStream ins = socket.getInputStream();
        //获取客户端输出流
        OutputStream ous = socket.getOutputStream();
        //服务端向客户端写出数据
        ous.write("百度一下你就知道".getBytes());
        byte[] arr = new byte[1024];
        //读取客户端发过来的数据
        int len = ins.read(arr);
        //将数据转换成字符串并打印
        System.out.println(new String(arr, 0, len));
        socket.close();

    }

}
