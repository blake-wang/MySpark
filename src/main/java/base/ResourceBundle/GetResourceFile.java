package base.ResourceBundle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by wanglei on 2017/10/30.
 * 获取各种路径下的资源文件
 */
public class GetResourceFile {
    public static void main(String[] args)
            throws IOException
    {
        //第一种方式
//        getResourceFileOne();
        //第二种方式
        getResourceFileTwo();
    }


    /**
     * ResourceBundle 资源文件加载器
     * 适用范围：web项目，java项目都可以，只要有src目录就可以了
     * 它只能加载src下的资源,文件要放在 /src/main/resources 目录下
     */
    private static void getResourceFileOne() {
        //windows系统中,一个文件全名，由 [基名.扩展名] 构成
        //传入参数为文件的基名

        //得到/src/main/resources下的cfg.properties
        ResourceBundle rb    = ResourceBundle.getBundle("cfg");
        String         value = rb.getString("a");
        System.out.println(value);

    }

    /**
     * 用类加载器ClassLoader
     * 默认加载的是 /src/main/java 目录下的资源文件,也就是classes目录下
     */
    private static void getResourceFileTwo()
            throws IOException
    {
        ClassLoader classLoader = new GetResourceFile().getClass()
                                                       .getClassLoader();
        InputStream is = classLoader.getResourceAsStream("../resources/cfg.properties");
        Properties pro = new Properties();
        pro.load(is);
        String value = pro.getProperty("a");
        System.out.println(value);
    }


}
