package base.FileDemo;

import java.io.File;

/**
 * Created by wanglei on 2018/1/15.
 * File类
 * <p>
 * File类更应该叫做一个路径
 * 文件路径或者文件夹路径
 * 路径分为绝对路径和相对路径
 * 绝对路径是一个固定的路径，从盘符开始
 * 相对路径相对于某个位置，在eclipse下是指当前项目下，在doc下指的是当前路径
 * <p>
 * File(String pathname):根据一个路径得到File对象
 * File(String parent,String child)：根据一个目录和一个子文件/目录得到File对象
 * File(File parent,String child)：根据一个父File对象和一个子文件/目录得到File对象
 */
public class fileDemo1 {
    public static void main(String[] args) {
//        demo1();
//        MyThreadDemo();
//        demo3();


    }

    private static void demo3() {
        File parent = new File("F:\\Data");
        String child = "haha.txt";
        File file = new File(parent, child);
        System.out.println(parent.exists());
        System.out.println(file.exists());
    }

    private static void demo2() {
        //父目录，child可以是目录，也可以是文件
        //对于child子文件的判断，忽略名称大小写的
        String parent = "F:\\Data";
        String child = "Haha.txt";
        File file = new File(parent, child);
        System.out.println(file.exists());
    }

    private static void demo1() {
        //绝对路径
        File file = new File("F:\\Data\\haha.txt");
        System.out.println(file.exists());

        //相对路径，指的是当前项目目录下
        File file2 = new File("pom.xml");
        System.out.println(file2.exists());
    }

}
