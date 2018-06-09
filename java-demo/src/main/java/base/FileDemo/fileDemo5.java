package base.FileDemo;

import java.io.File;

/**
 * Created by wanglei on 2018/1/15.
 * File 获取功能
 * <p>
 * getAbsolutePath()    获取绝对路径
 * getPath()    获取路径
 * getName()    获取名称
 * length()     获取长度。字节数
 * lastModified()   获取最后一次的修改时间，毫秒值
 * list()       获取指定目录下的所有文件或者文件夹的名称数组
 * listFiles()  获取指定目录下的所有文件或者文件夹的File数组
 */
public class fileDemo5 {
    public static void main(String[] args) {
//        demo();


        File file1 = new File("F:\\IdeaProjects\\MySpark\\src\\testData");
        String[] list = file1.list();   //获取文件名
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("------------------------");
        File[] files = file1.listFiles();   //获取文件对象
        for (File file : files) {
            System.out.println(file);
            boolean directory = file.isDirectory();
            System.out.println(directory);
        }


    }

    private static void demo() {
        File file1 = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\xxx.txt");
        File file2 = new File("xxx.txt");

        //获取绝对路径，与构造方法里面传入相对还是绝对路径无关
        String absolutePath = file1.getAbsolutePath();
        System.out.println("absolutePath :" +absolutePath);

        //getPath() 获取的就是构造方法里面所传的路径
        String path = file1.getPath();
        System.out.println("path :" +path);
        String path1 = file2.getPath();
        System.out.println("path1 :" +path1);

        //获取文件名称，也能获取文件夹
        String name = file1.getName();
        System.out.println("name :" + name);
        String name1 = file2.getName();
        System.out.println("name1 :" + name1);

        //获取文件的字节大小
        long length = file1.length();
        System.out.println(length);

        //获取文件的最后修改时间，如果不存在，就是0
        long l = file1.lastModified();
        System.out.println("l :" + l);


    }
}
