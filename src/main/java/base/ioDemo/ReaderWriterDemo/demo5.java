package base.ioDemo.ReaderWriterDemo;

import java.io.*;

/**
 * Created by wanglei on 2018/1/17.
 * 用指定的编码表读取文件
 * 用指定的编码表写文件
 */
public class demo5 {
    public static void main(String[] args) throws IOException {
//        demo1();

        BufferedReader br =
                new BufferedReader(new InputStreamReader(new FileInputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\fr.txt"), "utf-8"));
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\fryy.txt"), "utf-8"));
        int i;
        while ((i = br.read()) != -1) {
            bw.write(i);
        }

        br.close();
        bw.close();

    }

    private static void demo1() throws IOException {
        //用指定的编码表读
        InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\fr.txt"), "utf-8");
        //用指定的编码表写
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("F:\\IdeaProjects\\MySpark\\src\\testData\\frrr.txt"), "gbk");
        int i;
        while ((i = isr.read()) != -1) {
            osw.write(i);
        }

        isr.close();
        osw.close();
    }
}
