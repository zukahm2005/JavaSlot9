package session14.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionDB {
    public static Connection getMySQLConnection() throws SQLException {
        Connection conn = null;
        String hostName = "localhost";
        String dbName = "nhom1";
        String userName = "root";
        String password = "";

        String connectionURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
        conn = DriverManager.getConnection(connectionURL,userName,password);

        return conn;
    }
}
