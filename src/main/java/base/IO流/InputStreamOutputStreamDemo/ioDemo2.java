package base.IO流.InputStreamOutputStreamDemo;

import java.io.*;

/**
 * Created by wanglei on 2018/1/16.
 * <p>
 * BufferedInputStream和 BufferedOutputStream
 */
public class ioDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("F:\\11.bmp");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("F:\\22.bmp");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int len;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }
        //刷新一次缓冲区
//        bos.flush();

        bis.close();
        bos.close();
    }
}
