package models;


public class Book {

    private int bookId;

    private String name;

    private String author;

    private int amount;

    public Book() {

    }

    public Book(int bookId,String name, String author, int amount) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.amount = amount;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
