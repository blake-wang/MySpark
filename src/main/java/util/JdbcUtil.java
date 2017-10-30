package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by wanglei on 2017/10/28.
 */
public class JdbcUtil {

    public static final String URL = "jdbc:mysql://192.168.126.142:3306/testJdbc";
    public static final String USER = "root";
    public static final String PASSWORD = "hadoop";


    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接不成功："+e);
            return null;
        }
    }

    public static void main(String[] args) {
        getConnection();
    }

}
