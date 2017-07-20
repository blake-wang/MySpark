import java.sql.*;

/**
 * Created by JSJSB-0071 on 2017/7/20.
 */
public class DbUtil {
    public static final String URL = "jdbc:mysql://192.168.126.142:3306/testJdbc";
    public static final String USER = "root";
    public static final String PASSWORD = "hadoop";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2、获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3、操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs  = stmt.executeQuery("select user_name,age from imooc_goddess");
        //如果有数据,rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("user_name")+" 年龄："+rs.getInt("age"));
        }

    }
}
