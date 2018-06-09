package base.IO流.InputStreamOutputStreamDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/16.
 * 字节流读取中文的问题
 * 字节流在读取中文的时候可能会读到半个中文，造成乱码
 * 字节流写出中文的问题
 * 字节流直接操作的字节，所以写出中文必须将字符串转换成字节数组
 * 写出回车换行write("\r\n".getBytes());
 */
public class ioDemo3 {
    public static void main(String[] args) throws IOException {
//        demo1();

        //字节流只能写出字节，所以要先将字符串转换成字节数组
        FileOutputStream fos = new FileOutputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\xyz.txt");
        fos.write("基础不牢，地动山摇".getBytes());
        fos.write("\r\n".getBytes());//换行
        fos.close();

    }

    private static void demo1() throws IOException {
        FileInputStream fis = new FileInputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\xxx.txt");
        int len;
        //中文一般是2个字节，定义字节数组长度为3，有可能读出来就是乱码
        byte[] arr = new byte[3];
        while ((len = fis.read(arr)) != -1) {
            System.out.println(new String(arr, 0, len));
        }
        fis.close();
    }
}
