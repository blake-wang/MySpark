package base.Socket.Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wanglei on 2017/10/29.
 * 服务端，服务永远不停
 * 就是通过socket通信写出来的
 */
public class Server {
    public static void main(String[] args)
            throws Exception {
        ServerSocket server = new ServerSocket(54321);
        System.out.println("服务器启动，绑定54321端口");
        while (true) {
            final Socket socket = server.accept();
            new Thread() {
                @Override
                public void run() {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        String line = br.readLine();
                        System.out.println(line);
                        line = new StringBuffer(line).reverse().toString();
                        ps.println(line);
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
