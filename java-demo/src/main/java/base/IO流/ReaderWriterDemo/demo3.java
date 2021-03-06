package base.IO流.ReaderWriterDemo;

import java.io.*;

/**
 * Created by wanglei on 2018/1/17.
 * BufferedReader 和 BufferedWriter
 * 带缓冲区的reader和writer
 * 一个字符一个字符的拷贝
 * 底层是有一个8192个字符大小的缓冲区，也就是 8192 * 2 个字节大小
 */
public class demo3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("F:\\IdeaProjects\\MySpark\\src\\testData\\nextjson.json"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\IdeaProjects\\MySpark\\src\\testData\\copy2.json"));
        int c;
        while ((c = br.read()) != -1) { //如果一个字符一个字符的读，-1是结束标识符
            bw.write(c);
        }
        br.close();
        bw.close();

    }
}
