package base.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by wanglei on 2017/11/5.
 */
public class JdbcUtil {
    private static String driverClass;
    private static String url;
    private static String user;
    private static String password;

    static{
        try {
            ClassLoader cl = JdbcUtil.class.getClassLoader();
            InputStream is = cl.getResourceAsStream("dbcfg.properties");
            Properties prop = new Properties();
            prop.load(is);
            driverClass = prop.getProperty("driverClass");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
        } catch (IOException e) {
            throw new ExceptionInInitializerError("获取数据库配置文件信息失败");
        }
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("加载驱动失败");
        }
    }

    public static Connection getConnetion() {
        try {
            //2:获取与数据库的连接
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            throw new RuntimeException("连接数据库的url或用户名密码错误,请检查您的配置文件");
        }
    }

    public static void release(ResultSet resultSet, Statement stmt, Connection conn) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }

    }
}
