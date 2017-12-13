package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by bigdata on 17-12-13.
 * 从配置文件中获取属性值工具类
 */
public class ConfigurationUtil {
    public static void main(String[] args) {
        String value = getProperty("jdbc.url");
        System.out.println(value);
    }

    //获取运行环境
    public static String getEnvProperty(String key) {
        Properties properties = new Properties();
        InputStream in = ConfigurationUtil.class.getClassLoader().getResourceAsStream("env.properties");
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = (String) properties.get(key);
        return value;
    }

    //获取属性值
    public static String getProperty(String key) {
        Properties properties = new Properties();
        InputStream in = ConfigurationUtil.class.getClassLoader().getResourceAsStream(getEnvProperty("env.conf"));
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = (String) properties.get(key);
//        String value = (String)properties.getProperty(key,"not exists");
        return value;
    }
}
