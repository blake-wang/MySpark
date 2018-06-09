package base.IO流.ReaderWriterDemo;

import java.io.*;

/**
 * Created by wanglei on 2018/1/17.
 * 整行读，整行写
 * BufferedReader  的 readLine()
 * BufferedWriter  的 newLine()
 *
 * newLine() 与 \r\n的区别
 * newLine()是跨平台的方法
 * \r\n只支持windows系统
 * \n只支持linux系统
 * \r只支持mac系统
 */
public class demo4 {
    public static void main(String[] args) throws IOException {
//        demo();
        BufferedReader br = new BufferedReader(new FileReader("F:\\IdeaProjects\\MySpark\\src\\testData\\nextjson.json"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\IdeaProjects\\MySpark\\src\\testData\\copy3.json"));
        String line;
        while ((line = br.readLine()) != null) {    //如果一行一行的读， null 是结束标识符
            bw.write(line);
            bw.newLine();   //写出回车换行符，每写一行要记得换行
        }
        br.close();
        bw.close();


    }

    private static void demo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("F:\\IdeaProjects\\MySpark\\src\\testData\\nextjson.json"));
        String line;    //定义接收行的字符串
        while ((line = br.readLine()) != null) {    //一行一行读
            System.out.println(line);

        }
        br.close();
    }
}
