package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

/**
 * Created by bigdata on 17-11-6.
 */


/**
 * Created by zpf on 2016/8/26.
 * 数据库连接池
 */
public class ConnectionPool {
    private static LinkedList<Connection> connectionQueue;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Connection getConnection() {
        try {
            if (connectionQueue == null) {
                connectionQueue = new LinkedList<Connection>();
                for (int i = 0; i < 5; i++) {
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://Master:3306/sparkstreaming",
                            "root",
                            "12345");
                    connectionQueue.push(conn);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connectionQueue.poll();

    }

    public static void returnConnection(Connection conn) {
        connectionQueue.push(conn);
    }
}

