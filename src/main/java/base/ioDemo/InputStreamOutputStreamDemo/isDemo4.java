package base.ioDemo.InputStreamOutputStreamDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/16.
 * 流的标准异常处理代码
 * jdk 1.6及以前的
 */
public class isDemo4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\xyz.txt");
            fos = new FileOutputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\xyzxyz.txt");
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
}
