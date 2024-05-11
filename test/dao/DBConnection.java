package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getDBConnection() throws SQLException {
        Connection conn = null;
        String connectionURL = "jdbc:mysql://localhost:3306/nhom1";
        conn = DriverManager.getConnection(connectionURL,"root","");
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        if(getDBConnection()!=null){
            System.out.println("Connect Succesfully");
        }
    }
}
