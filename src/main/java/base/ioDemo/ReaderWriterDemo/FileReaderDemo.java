package base.ioDemo.ReaderWriterDemo;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/17.
 * FileReader
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
//        demo1();
        FileReader fr = new FileReader("F:\\IdeaProjects\\MySpark\\src\\testData\\xyz.txt");
        int i;
        while ((i = fr.read()) != -1) { //通过项目默认的码表一次读取一个字符。
            System.out.println((char) i);
        }
        fr.close();
    }

    private static void demo1() throws IOException {
        FileReader fr = new FileReader("F:\\IdeaProjects\\MySpark\\src\\testData\\xyz.txt");
        int i = fr.read();//读取一个字符，会自动类型提升为int
        System.out.println(i);
        char c = (char) i;
        System.out.println(c);
        fr.close();
    }
}
