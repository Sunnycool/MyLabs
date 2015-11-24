package db;

import java.sql.*;
import java.util.Arrays;


public class DB {
    private static final String DB_NAME = "javaee"; //sql495751
    private static final String USERNAME = "root";//sql495751
    private static final String PASSWORD = "root";//gQ6!jA2%
    private static final String DB_HOST = "localhost:3306";//sql4.freemysqlhosting.net
    private Connection connection;

    private static DB instance;

    public DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://" + DB.DB_HOST + "/" + DB.DB_NAME, DB.USERNAME, DB.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String query) {
        try {
            Statement st = this.connection.createStatement();

            return st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean execute(String query) {
        try {
            Statement st = this.connection.createStatement();
            return st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int executeInsert(String query) {
        try {
            Statement st = this.connection.createStatement();

            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = st.getGeneratedKeys();

            result.next();

            return result.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static DB getInstance() {
        if (DB.instance == null) {
            return new DB();
        }

        return DB.instance;
    }
}
