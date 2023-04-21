module lecture12.examprep.examprep {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens lecture12.examprep.examprep to javafx.fxml;
    exports lecture12.examprep.examprep;
}