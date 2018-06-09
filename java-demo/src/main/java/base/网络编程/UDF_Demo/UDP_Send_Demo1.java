package base.网络编程.UDF_Demo;

import java.io.IOException;
import java.net.*;

/**
 * Created by wanglei on 2018/1/23.
 * UDF
 * <p>
 * send  发送端
 */
public class UDP_Send_Demo1 {
    public static void main(String[] args) throws IOException {
        String str = "what are you ? 弄啥呢？";
        DatagramSocket socket = new DatagramSocket();   //创建Socket，相当于创建码头
        DatagramPacket packet =                         //创建Packet，相当于集装箱
                new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 9999);
        socket.send(packet);                            //发货，将数据发出去
        socket.close();                                 //关闭码头

    }
}
