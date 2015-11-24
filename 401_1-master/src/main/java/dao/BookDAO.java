package dao;

import db.DB;
import models.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BookDAO implements DAO<Book>{

    String tableName = "book";
    Connection db = null;
    Statement statement = null;

    @Override
    public Book add(Book model) throws SQLException {

        String insertTableSQL = "INSERT INTO " + tableName + " (bookId,name,author,amount) " + " VALUES (" +
                model.getBookId() + "," +
                model.getName() + "," +
                model.getAuthor() + "," +
                model.getAmount() + ")";

        try{
            db = DB.getConnect();
            statement = db.createStatement();
            statement.execute(insertTableSQL);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (statement != null){
                statement.close();
            }
            if (db != null){
                db.close();
            }
        }

        return null;
    }

    @Override
    public void delete(int id) throws SQLException {
        String deleteTableSQL = "DELETE from " + tableName + " WHERE bookId = " + id;

        try{
            db = DB.getConnect();
            statement = db.createStatement();
            statement.execute(deleteTableSQL);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (statement != null){
                statement.close();
            }
            if (db != null){
                db.close();
            }
        }
    }

    @Override
    public void update(Book model,int id) {
        String updateTableSQL = "UPDATE " + tableName + " SET bookId = " + model.getBookId() +
                ", name = " + model.getName() + ", author = " + model.getAuthor() +
                ", amount = " + model.getAmount() +
                " WHERE bookId = " + id;

        try{
            db = DB.getConnect();
            statement = db.createStatement();
            statement.execute(updateTableSQL);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void select(String param,char selection) throws SQLException {
        String selectAllTableSQL = "SELECT * from " + tableName;
        String selectNameTableSQL = "SELECT * from " + tableName + " WHERE name = " + param;
        String selectAuthorTableSQL = "SELECT * from " + tableName + " WHERE author = " + param;

        try{
            db = DB.getConnect();
            statement = db.createStatement();
            ResultSet resultSet = null;

            switch (selection){
                case 'a':
                    resultSet = statement.executeQuery(selectAllTableSQL);
                    break;
                case 'b':
                    resultSet = statement.executeQuery(selectNameTableSQL);
                    break;
                case 'c':
                    resultSet = statement.executeQuery(selectAuthorTableSQL);
                    break;
            }

            while (resultSet.next()){
                String bookId = resultSet.getString("bookId");
                String bookName = resultSet.getString("name");
                String bookAuthor = resultSet.getString("author");
                String bookAmount = resultSet.getString("amount");

                System.out.println("bookId: " + bookId);
                System.out.println("name: " + bookName);
                System.out.println("author: " + bookAuthor);
                System.out.println("amount: " + bookAmount + "\n");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (statement != null){
                statement.close();
            }
            if (db != null){
                db.close();
            }
        }
    }

}

