package db;

import core.IDB;
import interseptors.LoggingInterceptor;

import javax.enterprise.inject.Default;
import javax.interceptor.Interceptors;
import java.sql.*;
import java.util.Arrays;

@Default
@Interceptors(LoggingInterceptor.class)
public class DB implements IDB {
    private static final String DB_NAME = "cross_lab1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "dezertir29";
    private static final String DB_HOST = "localhost:3306";
    private Connection connection;

    //private static DB instance;

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
    /*public static DB getInstance() {
        if (DB.instance == null) {
            return new DB();
        }

        return DB.instance;
    }*/
}
