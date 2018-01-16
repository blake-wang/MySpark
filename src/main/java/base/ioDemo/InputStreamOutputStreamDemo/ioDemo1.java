package base.ioDemo.InputStreamOutputStreamDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/15.
 * 定义字节数组 的 标准写法
 * <p>
 * 先将字节读到字节数组中，再从字节数组中写出去
 * 字节数组一般定义成1024的整数倍
 */
public class ioDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\xxx.txt");
        FileOutputStream fos = new FileOutputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\yyy.txt");
        int len;
        byte[] arr = new byte[1024 * 8];
        while ((len = fis.read(arr)) != -1) {
            fos.write(arr, 0, len);
        }
        fis.close();
        fos.close();
    }
}
