package session14.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static session1.MySQLConnectDB.getMySqlConnection;

public class MySQLConnectionDB {
    public static Connection getMySQLConnection() throws SQLException {
        Connection conn = null;
        String dbURL = "jdbc:mysql://localhost:3306/nhom1";
        conn= DriverManager.getConnection(dbURL,"root","");
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        if(getMySqlConnection()!= null){
            System.out.println("Kết nối thành công");
        }
            Connection connection = getMySqlConnection();
    }

}
