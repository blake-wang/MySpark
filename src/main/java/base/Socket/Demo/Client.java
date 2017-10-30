package base.Socket.Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by wanglei on 2017/10/29.
 * 客户端
 * 创建Socket连接服务端(指定ip地址，端口号)通过ip地址找对应的服务器
 * 调用socket的getInputStream()和getOutputStream()方法获取和服务端相连的IO流
 * 输入流可以读取服务端输出流写出的数据
 * 输出流可以写出数据到服务端的输入流
 */
public class Client {
    public static void main(String[] args)
            throws IOException
    {
        Socket         socket = new Socket("127.0.0.1", 12345);
        InputStream    ins    = socket.getInputStream();
        BufferedReader br     = new BufferedReader(new InputStreamReader(ins));
        OutputStream   ous    = socket.getOutputStream();
        PrintStream    ps     = new PrintStream(ous);
        System.out.println(br.readLine());
        ps.println("我要学会网络编程！");
        System.out.println(br.readLine());
        ps.println("肯定能学会！");
        socket.close();

    }
}
