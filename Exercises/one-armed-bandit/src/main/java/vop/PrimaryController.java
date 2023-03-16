package vop;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class PrimaryController {

    Image[] images;
    Thread t1, t2, t3;
    int spinsAlive = 0;
    @FXML
    public ImageView spin1, spin2, spin3;
    @FXML
    public Button btn1, btn2, btn3, startSpinnersButton;
    @FXML
    public Label resultLabel;


    @FXML
    public void initialize() {
        images = new Image[10];
        for (int i = 0; i < images.length; i++) {
            try {
                images[i] = new Image(Objects.requireNonNull(getClass().getResource("fruits" + i + ".png")).toURI().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        spin1.setImage(images[1]);
        spin2.setImage(images[1]);
        spin3.setImage(images[1]);
        btn1.setDisable(true);
        btn2.setDisable(true);
        btn3.setDisable(true);
    }

    private synchronized void aliveCount(boolean up) {
        if (up) {
            spinsAlive++;
        } else {
            spinsAlive--;
        }

        System.out.println("Alive: " + spinsAlive);
        if (spinsAlive == 0) {
            startSpinnersButton.setDisable(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (spin1.getImage() == spin2.getImage() && spin1.getImage() == spin3.getImage()) {
                        resultLabel.setText("All 3 equals! JACKPOT!");
                    } else if (spin1.getImage() == spin2.getImage()
                            || spin1.getImage() == spin3.getImage()
                            || spin2.getImage() == spin3.getImage()) {
                        resultLabel.setText("2 equals! Congratulations!");
                    } else {
                        resultLabel.setText("You are a LOSER!");

                    }
                }
            });
        }
    }


    public class BanditRunnable implements Runnable {

        private int i;
        private long sleepTime;
        private boolean running;
        private ImageView iw;

        public BanditRunnable(int i, long sleepTime, ImageView iw) {
            this.i = i;
            this.sleepTime = sleepTime;
            this.iw = iw;
        }

        @Override
        public void run() {
            running = true;
            aliveCount(true);
            System.out.println("Thread started: " + Thread.currentThread());

            while (running) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        iw.setImage(images[i]);
                        i = (i + 1) % images.length;
                    }
                });
                synchronized (this) {
                    try {
                        //Thread.sleep(sleepTime);
                        wait(sleepTime);
                    } catch (InterruptedException ex) {
                        System.out.println("Interrupted: " + Thread.currentThread());
                        running = false;
                        aliveCount(false);
                    }
                }
            }
        }
    }
    public void startSpinnersHandler(ActionEvent event){
        t1 = new Thread(new BanditRunnable(0,120,spin1));
        t2 = new Thread(new BanditRunnable(0,100,spin2));
        t3 = new Thread(new BanditRunnable(0,140,spin3));
        t1.setDaemon(true);
        t2.setDaemon(true);
        t3.setDaemon(true);
        t1.start();
        t2.start();
        t3.start();
        startSpinnersButton.setDisable(true);
        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        resultLabel.setText("Running...");
    }

    public void stopSpinnersHandler(ActionEvent event){
        if (((Button)event.getSource()).equals(btn1)){
            t1.interrupt();
            btn1.setDisable(true);
        } else if (((Button)event.getSource()).equals(btn2)){
            t2.interrupt();
            btn2.setDisable(true);
        } else {
            t3.interrupt();
            btn3.setDisable(true);
        }
        if (t1.isInterrupted() && t2.isInterrupted() && t3.isInterrupted()){
            startSpinnersButton.setDisable(false);
        }
    }
}
