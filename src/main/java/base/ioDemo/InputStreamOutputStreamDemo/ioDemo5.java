package base.ioDemo.InputStreamOutputStreamDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/16.
 * 流的标准异常处理代码
 * jdk  1.7版本
 *
 * 原理：
 *  在try()中创建的流对象必须实现了AutoCloseable 这个接口，如果实现了，在try后面的{}(读写代码)执行后就会自动调用，流对象的close方法将流关掉
 */
public class ioDemo5 {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\xyz.txt");
                FileOutputStream fos = new FileOutputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\xyzxxx.txt");
        ) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        }
    }
}
