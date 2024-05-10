package session14.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionDB {
    public static Connection getMySQLConnection() throws SQLException {
        Connection conn = null;
        String dbURL = "jdbc:mysql://localhost:3306/nhom1";
        conn= DriverManager.getConnection(dbURL,"root","");
        return conn;
    }


}
