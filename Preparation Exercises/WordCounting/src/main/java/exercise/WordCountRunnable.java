package exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCountRunnable implements Runnable {

    private final File file;

    public WordCountRunnable(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNext()) {
                String word = scanner.next();
                i++;
            }
            System.out.println("File: " + file.getName() + " Word Count: " + i);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
