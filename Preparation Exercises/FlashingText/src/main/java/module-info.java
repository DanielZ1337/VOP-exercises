module com.example.flashingtext {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.flashingtext to javafx.fxml;
    exports com.example.flashingtext;
}