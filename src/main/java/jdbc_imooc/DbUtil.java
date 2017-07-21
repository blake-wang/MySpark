package jdbc_imooc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by JSJSB-0071 on 2017/7/20.
 */
public class DbUtil {
    public static final String URL = "jdbc:mysql://192.168.126.142:3306/testJdbc";
    public static final String USER = "root";
    public static final String PASSWORD = "hadoop";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接不成功:" + e);
            return null;
        }
    }
}
