package com.example.flashingtext;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private Label funLabel;
    private String text;
    private ToggleGroup toggleGroup = new ToggleGroup();
    @FXML
    private Button startButton, stopButton;
    @FXML
    private RadioButton r100, r200, r400;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        r100.setToggleGroup(toggleGroup);
        r200.setToggleGroup(toggleGroup);
        r400.setToggleGroup(toggleGroup);
        r100.setSelected(true);

        thread.setDaemon(true);
        thread.start();
    }

    private Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    if (funLabel.getText().trim().length() == 0) {
                        text = "Welcome";
                    } else {
                        text = "";
                    }
                    System.out.println("Flash: " + text);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            funLabel.setText(text);
                        }
                    });

                    Thread.sleep(Integer.parseInt(((RadioButton) toggleGroup.getSelectedToggle()).getId()));
                }
            } catch (InterruptedException ex) {
            }

        }

    });

    public void stopButtonAction(ActionEvent event) {
        thread.interrupt();
    }

    public void startButtonAction(ActionEvent event) {
        this.thread = new Thread(thread);
        thread.setDaemon(true);
        thread.start();
    }
}
