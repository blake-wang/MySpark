package base.网络编程.UDF_Demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by wanglei on 2018/1/23.
 *
 * receive 接收端
 */
public class UDP_Receive_Demo1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);   //创建Socket，相当于创建码头
        DatagramPacket packet =                         //创建Packet，相当于创建集装箱
                new DatagramPacket(new byte[1024],1024);
        socket.receive(packet);                         //接货，接收数据
        byte[] data = packet.getData();                 //获取数据
        int len = packet.getLength();                   //获取有效的字节个数
        System.out.println(new String(data,0,len));
        socket.close();
    }
}
