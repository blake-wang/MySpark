package base.ioDemo.InputStreamOutputStreamDemo;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/15.
 * FileOutputStream
 *
 * FileOutputStream在创建对象的时候，如果没有这个文件会帮我们创建
 * 如果有这个文件，会现将文件清空,如果想续写，就在第二个参数传true
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
//        demo();
        FileOutputStream fio = new FileOutputStream("yyy.txt",true);//创建输出流，如果路径不存在，就创建一个
        fio.write(97);  //虽然写出的是一个int数，但是到文件上的是一个字节，会自动去除前三个8位
        fio.write(98);
        fio.write(99);
        fio.close();

    }

    private static void demo() throws IOException {
        FileOutputStream fio = new FileOutputStream("yyy.txt");//创建输出流，如果路径不存在，就创建一个
        fio.write(97);  //虽然写出的是一个int数，但是到文件上的是一个字节，会自动去除前三个8位
        fio.write(98);
        fio.write(99);
        fio.close();
    }
}
