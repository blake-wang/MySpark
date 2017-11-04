package base.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by bigdata on 17-11-5.
 */
public class JdbcUtilTest {
    public static void main(String[] args) {
        Connection conn      = null;
        Statement stmt      = null;
        ResultSet resultSet = null;
        try {
            conn = JdbcUtil.getConnetion();
            stmt = conn.createStatement();
            //4:执行SQL语句
            resultSet = stmt.executeQuery("select distinct user_name from imooc_goddess");
            //5:如果执行的是查询语句，要对结果进行处理
            while (resultSet.next()) {
                String user_name = resultSet.getString("user_name");
                System.out.println("user_name : " + user_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(resultSet,stmt,conn);
        }
    }
}
