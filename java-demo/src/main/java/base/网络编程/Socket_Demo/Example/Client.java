package base.网络编程.Socket_Demo.Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by wanglei on 2017/10/29.
 * 客户端向服务器写字符串(键盘录入),服务器(多线程)将字符串反转后写会，客户端再次读取到的是反转后的字符串
 */
class Client {
    public static void main(String[] args)
            throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 54321);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println(sc.nextLine());
        System.out.println(br.readLine());
        socket.close();
    }

}
