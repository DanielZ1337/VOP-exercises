package vop;

public class Book {

    private String name;
    private String author;
    private BookType bookType;

    public Book(String name, String author, BookType bookType) {
        this.name = name;
        this.author = author;
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return name + " is written by " + author + " and is a " + bookType;
    }

    public static void main(String[] args) {


        Book b = new Book("The Great Gatsby", "Francis Scott Fitzgerald", BookType.HARDCOVER);
        System.out.println(b);
    }
}
