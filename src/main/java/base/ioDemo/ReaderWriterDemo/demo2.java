package base.ioDemo.ReaderWriterDemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/17.
 * 定义缓冲字符数组
 */
public class demo2 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("F:\\IdeaProjects\\MySpark\\src\\testData\\nextjson.json");
        FileWriter fw = new FileWriter("F:\\IdeaProjects\\MySpark\\src\\testData\\copy.json");
        int len;
        char[] arr = new char[1024 * 8];
        while ((len = fr.read(arr)) != -1) {    //将文件上的数据读取到字符数组中
            fw.write(arr,0,len);            //将字符数组中的数据写到文件上
        }
        fr.close();
        fw.close();
    }
}
