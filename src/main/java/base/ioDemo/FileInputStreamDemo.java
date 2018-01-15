package base.ioDemo;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/15.
 * FileInputStream
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
//        demo1();

        FileInputStream fis = new FileInputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\hello.txt");//创建流对象
        int a;
        while ((a = fis.read())!= -1) { //-1是文件结束标识符
            System.out.println(a);
        }
        fis.close();

    }

    private static void demo1() throws IOException {
        FileInputStream fis = new FileInputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\hello.txt");//创建流对象
        int read1 = fis.read();  //从硬盘上读取一个字节
        System.out.println(read1);
        int read2 = fis.read();
        System.out.println(read2);
        fis.close();//关闭流
    }
}
