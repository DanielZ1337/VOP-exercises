package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.HashMap;

public class PrimaryController {

    @FXML
    Label add_lbl_name, add_lbl_author, add_lbl_isbn, add_lbl_booktype, get_lbl_isbn;
    @FXML
    TextField add_txt_name, add_txt_isbn, add_txt_author, get_txt_isbn;
    @FXML
    ChoiceBox add_booktype_choice;
    @FXML
    Button add_btn, get_btn;
    @FXML
    TextArea add_output, get_output;
    HashMap<String, Book> books;


    @FXML
    public void initialize() {
        books = new HashMap<>();
        add_booktype_choice.getItems().addAll(BookType.values());

    }

    public void add_book(ActionEvent actionEvent) {
        String name = add_txt_name.getText();
        String author = add_txt_author.getText();
        String isbn = add_txt_isbn.getText();
        BookType bookType = (BookType) add_booktype_choice.getValue();
        if (name.isEmpty() || author.isEmpty() || isbn.isEmpty() || bookType == null) {
            add_output.setText("Please fill out all fields");
        } else if (books.containsKey(isbn)) {
            add_output.setText("Book already exists");
        } else {
            Book book = new Book(name, author, bookType);
            books.put(isbn, book);
            add_output.setText("Book inserted with ISBN:\n" + isbn);
        }
    }

    public void get_book(ActionEvent actionEvent) {
        String isbn = get_txt_isbn.getText();
        Book book = books.get(isbn);
        get_output.setText(book.toString());
    }
}