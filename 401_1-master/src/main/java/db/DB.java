package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String DB_NAME = "javaee";
    private static final String USERNAME = "root";//sql495751
    private static final String PASSWORD = "root";//gQ6!jA2%
    private static final String DB_HOST = "localhost:3306";//sql4.freemysqlhosting.net
    private static Connection connection;

    public DB(){

    }

    public static  Connection getConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + DB.DB_HOST + "/" + DB.DB_NAME, DB.USERNAME, DB.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
