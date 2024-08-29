package vn.edu.iuh.fit.nguyenthinga_session01.connectDB;

import java.sql.Connection;

public class ConnectDB {
    protected static Connection initializeDatabase() {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        // Database name to access
        String dbName = "userdb";
        String dbUsername = "root";
        String dbPassword = "sapassword";
        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return con;
    }
}
