package base.FileDemo;

import java.io.File;

/**
 * Created by wanglei on 2018/1/15.
 * File类的判断功能
 * <p>
 * isDirectory() //是否是目录
 * isFile()      //判断是否是文件
 * exists()      //判断是否存在
 * canRead()     //判断是否可读
 * canWrite()    //判断是否可写
 * isHidden()    //判断是否隐藏
 */
public class fileDemo4 {
    public static void main(String[] args) {
        File file = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\xxx.txt");
        boolean b1 = file.isDirectory();
        System.out.println(b1);

        File file1 = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\fileDemo2");
        boolean b2 = file1.isDirectory();
        System.out.println(b2);

        File file2 = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\xxx.txt");
        boolean b3 = file2.isFile();
        System.out.println(b3);

        File file3 = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\xxx.txt");
        boolean b4 = file3.exists();
        System.out.println(b4);

        boolean b5 = file3.canRead();
        System.out.println(b5);


        boolean b6 = file3.canWrite();
        System.out.println(b6);

        boolean b7 = file3.isHidden();
        System.out.println(b7);


    }
}
