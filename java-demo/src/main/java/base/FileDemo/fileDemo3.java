package base.FileDemo;

import java.io.File;

/**
 * Created by wanglei on 2018/1/15.
 * 重名名和删除功能
 * rename()
 * delete()
 *
 *
 * <p>
 * 重命名注意事项：如果路径名相同，就是改名，如果路径名不同，就是改名并剪切
 * 删除注意事项：JAVA中的删除不走回收站。要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
 */
public class fileDemo3 {
    public static void main(String[] args) {
//        renameTo();

        File file = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\ooo.txt");
        boolean delete = file.delete();
        System.out.println(delete);

        //要删除的文件家内不能包含文件或者文件夹
        File file1 = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\fileDemo");
        boolean delete1 = file1.delete();
        System.out.println(delete1);

        File file2 = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\fileDemo2");
        boolean delete2 = file2.delete();
        System.out.println(delete2);


    }

    private static void renameTo() {
        File file1 = new File("F:\\IdeaProjects\\MySpark\\src\\testData\\ooo.txt");
        File file2 = new File("F:\\xxx.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }
}
