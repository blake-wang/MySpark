package base.FileDemo;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by wanglei on 2018/1/15.
 * 文件名称过滤器
 *
 */
public class fileDemo6 {

    public static void main(String[] args) {

        File file = new File("F:\\IdeaProjects\\MySpark\\src\\testData");
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
//                System.out.println(dir);
//                System.out.println(name);

                //返回true，是全部不过滤
                //返回false，是全部过滤
                File file = new File(dir,name);

                return file.isFile() && file.getName().endsWith(".json");
            }
        });
        for (String s : list) {
            System.out.println(s);
        }

    }
}
