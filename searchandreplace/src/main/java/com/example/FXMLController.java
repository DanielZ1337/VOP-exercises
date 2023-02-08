package com.example;


import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FXMLController implements Initializable {

    @FXML
    public Button replaceAllButton;
    @FXML
    public TextField replaceField, searchField;
    @FXML
    public TextArea textArea;
    public FileChooser fileChooser = new FileChooser();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser.setInitialDirectory(new File("."));
    }

    public void replaceActionHandler(ActionEvent event) {
        textArea.setText(textArea.getText().replaceAll(searchField.getText(), replaceField.getText()));
    }

    public void openFileActionHandler(ActionEvent event) throws FileNotFoundException {
        File inFile = fileChooser.showOpenDialog(null);
        if (inFile != null) {
            StringBuilder inputString = new StringBuilder();
            Scanner scanner = new Scanner(inFile);
            while (scanner.hasNextLine()) {
                inputString.append(scanner.nextLine()).append("\n");
            }
            textArea.setText(String.valueOf(inputString));
        }
    }

    public void saveAsActionHandler(ActionEvent event) throws IOException {
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File outFile = fileChooser.showSaveDialog(null);
        if (outFile != null) {
            try {
                FileWriter fileWriter = new FileWriter(outFile);
                fileWriter.write(textArea.getText());
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error occurred");
            }
        }
    }
}
