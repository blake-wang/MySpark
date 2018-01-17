package base.ioDemo.ReaderWriterDemo;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/17.
 * FileWriter
 */
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("F:\\IdeaProjects\\MySpark\\src\\testData\\fr.txt");
        fw.write("基础不牢，地动山摇。日积硅步，功不唐捐");
        fw.write(97);
        fw.close();
    }
}
