package base.jdcb_yibai;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by JSJSB-0071 on 2017/7/21.
 */
public class CommitDemo {

    public static void main(String[] args) throws SQLException {
        Connection conn = DbUtil.getConnection();

        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        String SQL = "insert into employees values (106,20,'Rita','Tez')";
        stmt.executeUpdate(SQL);
        String SQL2 = "INSERT INTO employees  " +
                "VALUES (107, 22, 'Sita', 'Singh')";
        stmt.executeUpdate(SQL2);
        conn.commit();
    }
}
