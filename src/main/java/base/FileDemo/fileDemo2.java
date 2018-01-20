package base.FileDemo;

import java.io.File;
import java.io.IOException;

/**
 * Created by wanglei on 2018/1/15.
 * File method
 * <p>
 * public boolean createNewFile():创建文件，如果存在这样的文件，就不创建了
 * public boolean mkdir():创建文件夹，如果存在这样的文件夹，就不创建了
 * public boolean mkdirs():创建文件夹，如果父文件夹不存在，会帮你创建出来
 */
public class fileDemo2 {
    public static void main(String[] args) throws IOException {


//        demo1();//创建文件
//        MyThreadDemo();//创建文件夹

        File file= new File("F:\\IdeaProjects\\MySpark\\src\\testData\\fileDemo2\\fileDemo3");
        boolean mkdir = file.mkdirs();//创建多级文件夹，如果父文件夹不存在，同时创建父文件夹
        System.out.println(mkdir);

    }

    private static void demo2() {
        File file = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\fileDemo");
        boolean mkdir = file.mkdir();//如果文件夹不存在，就创建，返回true。如果文件夹存在，就不创建，返回false；
        System.out.println(mkdir);
    }

    private static void demo1() throws IOException {
        File file = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\filedemo.txt");
        boolean newFile = file.createNewFile();//如果没有就创建，返回false。如果有就不创建，返回false
        System.out.println(newFile);
    }
}
