package base.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by wanglei on 2017/11/4.
 * 1:
 */
public class JdbcSimple {
    public static void main(String[] args) throws SQLException {
        //1:
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.126.142:3306/testJdbc");

    }
}
