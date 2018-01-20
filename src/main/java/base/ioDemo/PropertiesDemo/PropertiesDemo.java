package base.ioDemo.PropertiesDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by wanglei on 2018/1/19.
 * Properties
 * <p>
 * 是HashTable的子类
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
//        demo1();
//        setProperty();


        //用来加载resources目录下的资源文件 -->  这个非常重要
        Properties prop = new Properties();
        //返回输入流，流连接的是 resources/test.properties
        InputStream resourceAsStream = PropertiesDemo.class.getClassLoader().getResourceAsStream("test.properties");
        //加载输入流，并将文件上的键值对读取到集合中
        prop.load(resourceAsStream);

        String name = prop.getProperty("name");
        String age = prop.getProperty("age");
        String tel = prop.getProperty("tel");

        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("tel : " + tel);

        //修改文件中的键对应的值 ,将修改的简直写入到内存
        prop.setProperty("name", "马云");
        //将修改后的值从内存写入到文件，第二个参数是对列表参数的描述，可以给值，也可以给null
        prop.store(new FileOutputStream("src\\main\\resources\\test.properties"), "Hello Jack Ma");



        System.out.println("-------------分割线----------");


        Properties prop2 = new Properties();

        //用字节输入流读取文件，默认的项目目录是根目录
        prop2.load(new FileInputStream("src\\main\\resources\\test.properties"));

        Enumeration<String> enumeration = (Enumeration<String>) prop.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }


    }


    /**
     * setProperty()  getProperty
     */
    private static void setProperty() {
        Properties prop = new Properties();

        //设置属性
        prop.setProperty("name", "张三");
        prop.setProperty("age", "29");
        prop.setProperty("tel", "15814053390");
        //取出属性
        String name = prop.getProperty("name");
        String age = prop.getProperty("age");
        String tell = prop.getProperty("tell");//如果对应的键不存在，返回null

        System.out.println(name);
        System.out.println(age);
        System.out.println(tell);

        //propertyNames()返回全部键的枚举
        Enumeration<String> enumeration = (Enumeration<String>) prop.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();//获取property中的每一个键
            String value = prop.getProperty(key);   //根据键获取值
            System.out.println("枚举中取出的 " + key + " : " + value);
        }
    }


    /**
     * put()  get()
     */
    private static void demo1() {
        Properties prop = new Properties();
        prop.put("aaa", 123);
        System.out.println(prop.get("aaa"));
    }
}
