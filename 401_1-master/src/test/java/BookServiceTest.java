import dao.BookDAO;
import models.Book;
import org.junit.Test;

import java.sql.SQLException;

public class BookServiceTest {

    BookDAO bookService = new BookDAO();

    @Test
    public void saveBookRecord(){
        Book book = new Book(11,"\'book11\'","\'author11\'",119);
        try{
            bookService.add(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteBookRecord(){
        int id = 9;
        try{
            bookService.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAllBookRecord(){

        String param = "\'book1\'";
        String param1 = "\'author2\'";
        char s = 'a';
        try{
            bookService.select(param,s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateBookRecord(){
        Book book = new Book(5,"\'book5\'","\'author5\'",45);
        int id =4 ;
        bookService.update(book,id);
    }

}
