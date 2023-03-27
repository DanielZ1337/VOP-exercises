/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author erso
 */
public class FacadeWithCallback extends Thread {

    private CallBackInterface callBack;
    private File pathToPics;
    private File[] pictures;

    public FacadeWithCallback(CallBackInterface callBack) throws URISyntaxException {
        this(callBack,  FacadeWithCallback.class.getResource("").toURI().getPath());
    }

    public FacadeWithCallback(CallBackInterface callBack, String pathToPics) {
        this.callBack = callBack;
        this.pathToPics = new File(pathToPics);
        pictures = loadPictures();
    }

    private File[] loadPictures() {

        System.out.println("Pics: " + pathToPics.getAbsolutePath());

        File[] pictures = pathToPics.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".png");
            }
        });

        System.out.println("Files: " + Arrays.toString(pictures));
        return pictures;
    }

    public File getPic(int index) {
        return pictures[index];
    }

    public void run() {
        System.out.println("RUNNING");
        int d1 = 0;
        int d2 = 0;
        try {
            Dice dice = new Dice();
            while (!dice.equalsMax()) {
                dice.throwDice();
                d1 = dice.getDie1();
                d2 = dice.getDie2();
                callBack.updateMessage(dice.toString());
                callBack.updateImages(getPic(d1 - 1), getPic(d2 - 1));
                synchronized (this) {
                    wait(100);
                }
            }
        } catch (InterruptedException ex) {
            callBack.updateMessage("I GOT INTERRUPTED!!!");
        }
        callBack.updateMessage("Over And Out...,");
    }

    public static void main(String[] arg) throws URISyntaxException {
        // CallBack implementation for testing
        CallBackInterface soutCallBack = new CallBackInterface() {
            @Override
            public void updateMessage(String message) {
                System.out.println(message);
            }

            @Override
            public void updateImages(File i1, File i2) {
                System.out.println("Pics: " + i1.getName() + " " + i2.getName());
            }
        };

        FacadeWithCallback facade = new FacadeWithCallback(soutCallBack, FacadeWithCallback.class.getResource("").toURI().getPath());

        facade.start();
        try {
            facade.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(FacadeWithCallback.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
