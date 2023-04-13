module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens vop.ui to javafx.fxml;
    exports vop.ui;
}
