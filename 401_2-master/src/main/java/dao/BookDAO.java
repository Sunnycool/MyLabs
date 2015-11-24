package dao;

import db.DB;
import models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public static Book create(Book Book) {
        DB db = DB.getInstance();

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

    public static Book read(int id) {
        DB db = DB.getInstance();

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

    public static void delete(int id) {
        DB db = DB.getInstance();

        String tableName = Book.tableName;

        db.execute("DELETE FROM " + tableName + " WHERE bookId = " + id );
    }

    public static void update(Book Book) {
        DB db = DB.getInstance();

        String tableName = Book.tableName;

        db.execute("UPDATE " + tableName + " SET " +
                "bookId = " + Book.getEnterpriseId() + ", " +
                "name = \"" + Book.getName() + "\", " +
                "author = \"" + Book.getBranch() + "\"," +
                "amount = \"" + Book.getEmployeeCount() + "\" " +
                "WHERE bookId = " + Book.getEnterpriseId());
    }

    public static List<Book> findByAuthor(String branch) {
        DB db = DB.getInstance();

        String tableName = Book.tableName;

        ArrayList<Book> list = new ArrayList<>();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + " WHERE author = \"" + branch + "\";");

        try {
            while (resultSet.next()) {
                Book book = new Book();

                book.setEnterpriseId(resultSet.getInt(1));
                book.setName(resultSet.getString(2));
                book.setBranch(resultSet.getString(3));
                book.setEmployeeCount(resultSet.getInt(4));

                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Book> findByName(String name) {
        DB db = DB.getInstance();

        String tableName = Book.tableName;


        ArrayList<Book> list = new ArrayList<>();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + " WHERE name = \"" + name + "\";");

        try {
            while (resultSet.next()) {
                Book book = new Book();

                book.setEnterpriseId(resultSet.getInt(1));
                book.setName(resultSet.getString(2));
                book.setBranch(resultSet.getString(3));
                book.setEmployeeCount(resultSet.getInt(4));

                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static List<Book> findAll() {
        DB db = DB.getInstance();

        String tableName = Book.tableName;


        ArrayList<Book> list = new ArrayList<>();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + ";");

        try {
            while (resultSet.next()) {
                Book book = new Book();

                book.setEnterpriseId(resultSet.getInt(1));
                book.setName(resultSet.getString(2));
                book.setBranch(resultSet.getString(3));
                book.setEmployeeCount(resultSet.getInt(4));

                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
