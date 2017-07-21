package jdcb_yibai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by JSJSB-0071 on 2017/7/21.
 */
public class DbUtil {
    //使用的数据库是emp

    public static final String URL = "jdbc:mysql://192.168.126.142:3306/emp";
    public static final String USER = "root";
    public static final String PASSWORD = "hadoop";


    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败 ： " + e);
            return null;
        }

    }

}
