package exercise;

public class WordCount {

    public static void main(String[] args) {
        String[] fileNames = {"alice30.txt", "Boscombe.txt", "Snow White.txt"};
        for (int i = 0; i < fileNames.length; i++) {
            Runnable wcr = new WordCountRunnable("Preparation Exercises/WordCounting/" + fileNames[i]);
            Thread t = new Thread(wcr);
            t.start();
        }
    }


}
