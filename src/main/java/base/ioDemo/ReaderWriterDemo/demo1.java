package base.ioDemo.ReaderWriterDemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/17.
 * 文件拷贝
 * <p>
 * 一个字符等于2个字节
 * 字符流不能用于拷贝文件
 */
public class demo1 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("F:\\IdeaProjects\\MySpark\\src\\testData\\fr.txt");
        FileWriter fw = new FileWriter("F:\\IdeaProjects\\MySpark\\src\\testData\\fw.txt");
        int i;
        while ((i = fr.read()) != -1) {
            fw.write(i);
        }
        fr.close();
        fw.close(); //Writer类中有一个2k的小缓冲区，如果不关流，就会将内容写到缓冲区里。关流，会将缓冲区内容刷新写出，再关闭。
    }
}
