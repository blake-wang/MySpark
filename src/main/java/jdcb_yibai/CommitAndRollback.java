package jdcb_yibai;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by JSJSB-0071 on 2017/7/21.
 */
public class CommitAndRollback {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DbUtil.getConnection();
            conn.setAutoCommit(false);


            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "INSERT INTO employees " +
                    "VALUES (106, 28, 'Curry', 'Stephen')";
            stmt.executeUpdate(sql);
            String sql2 = "INSERT INTO employees " +
                    "VALUES (107, 32, 'Kobe', 'Bryant')";
            stmt.executeUpdate(sql2);

            conn.commit();

            String sql3 = "SELECT id, first, last, age FROM employees";
            ResultSet rs = stmt.executeQuery(sql3);
            printRs(rs);
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Rolling back data here....");
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("good bye!");

    }


    public static void printRs(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");

            System.out.println(id + "  " + age + "  " + first + "  " + last);
        }
    }


}
