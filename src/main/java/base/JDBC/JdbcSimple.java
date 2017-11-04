package base.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by wanglei on 2017/11/4.
 * 1:注册数据库的驱动
 * 2:获取与数据库的连接
 * 3:创建代表SQL语句的对象
 * 4:执行SQL语句
 * 5:如果执行的是查询语句，要对结果进行处理
 * 6:释放占用的资源
 */
public class JdbcSimple {
    public static void main(String[] args)
    {
        Connection conn      = null;
        Statement  stmt      = null;
        ResultSet  resultSet = null;
        try {
            //1:注册数据库的驱动
            //        DriverManager.registerDriver(new com.mysql.jdbc.Driver());//这种方式不好，不推荐使用
            Class.forName("com.mysql.jdbc.Driver");
            //2:获取与数据库的连接
            conn = DriverManager.getConnection("jdbc:mysql://192.168.126.142:3306/testJdbc",
                                               "root",
                                               "hadoop");
            //3:创建代表SQL语句的对象
            stmt = conn.createStatement();
            //4:执行SQL语句
            resultSet = stmt.executeQuery("select distinct user_name from imooc_goddess");
            //5:如果执行的是查询语句，要对结果进行处理
            while (resultSet.next()) {
                String user_name = resultSet.getString("user_name");
                System.out.println("user_name : " + user_name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6:释放占用的资源
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
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }

        }


    }
}
