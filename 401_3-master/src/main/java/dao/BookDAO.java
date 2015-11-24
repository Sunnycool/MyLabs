package dao;

import core.IDB;
import interseptors.LoggingInterceptor;
import models.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class BookDAO {
    @Inject
    private IDB db;

    public Book create(Book Book) {

        String tableName = Book.tableName;

        int lastInsertedId = db.executeInsert("INSERT INTO " + tableName + " (bookId, name, author, amount)" +
                " VALUES (" +
                Book.getEnterpriseId() + ",\"" +
                Book.getName() + "\", \"" +
                Book.getBranch() + "\"," +
                Book.getEmployeeCount() +
                ");");
        Book.setEnterpriseId(lastInsertedId);

        return Book;
    }

    public Book read(int id) {
        String tableName = Book.tableName;
        Book Book = new Book();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + " WHERE bookId = " + id);

        try {
            if (resultSet.next()) {
                Book.setEnterpriseId(resultSet.getInt(1));
                Book.setName(resultSet.getString(2));
                Book.setBranch(resultSet.getString(3));
                Book.setEmployeeCount(resultSet.getInt(4));

                return Book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(int id) {
        String tableName = Book.tableName;

        db.execute("DELETE FROM " + tableName + " WHERE bookId = " + id );
    }

    public void update(Book Book) {
        String tableName = Book.tableName;

        db.execute("UPDATE " + tableName + " SET " +
                "bookId = " + Book.getEnterpriseId() + ", " +
                "name = \"" + Book.getName() + "\", " +
                "author = \"" + Book.getBranch() + "\"," +
                "amount = \"" + Book.getEmployeeCount() + "\" " +
                "WHERE bookId = " + Book.getEnterpriseId());
    }

    public List<Book> findByBranch(String branch) {
        String tableName = Book.tableName;

        ArrayList<Book> list = new ArrayList<>();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + " WHERE author = \"" + branch + "\";");

        try {
            while (resultSet.next()) {
                Book enterprise = new Book();

                enterprise.setEnterpriseId(resultSet.getInt(1));
                enterprise.setName(resultSet.getString(2));
                enterprise.setBranch(resultSet.getString(3));
                enterprise.setEmployeeCount(resultSet.getInt(4));

                list.add(enterprise);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Book> findByName(String name) {
        String tableName = Book.tableName;

        ArrayList<Book> list = new ArrayList<>();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + " WHERE name = \"" + name + "\";");

        try {
            while (resultSet.next()) {
                Book enterprise = new Book();

                enterprise.setEnterpriseId(resultSet.getInt(1));
                enterprise.setName(resultSet.getString(2));
                enterprise.setBranch(resultSet.getString(3));
                enterprise.setEmployeeCount(resultSet.getInt(4));

                list.add(enterprise);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<Book> findAll() {
        String tableName = Book.tableName;

        ArrayList<Book> list = new ArrayList<>();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + ";");

        try {
            while (resultSet.next()) {
                Book enterprise = new Book();

                enterprise.setEnterpriseId(resultSet.getInt(1));
                enterprise.setName(resultSet.getString(2));
                enterprise.setBranch(resultSet.getString(3));
                enterprise.setEmployeeCount(resultSet.getInt(4));

                list.add(enterprise);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
