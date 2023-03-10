package org.example.camelwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CamelWriter {

    private final File inFile;


    public CamelWriter(String fName) {
        this.inFile = new File(fName);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        CamelWriter cw = new CamelWriter("Preparation Exercises/CamelWriterExercise/DryLips.txt");
        cw.readLines();
        CamelWriter cw1 = new CamelWriter("Preparation Exercises/CamelWriterExercise/MaryAnn.txt");
        cw1.readLines();
        CamelWriter cw2 = new CamelWriter("Preparation Exercises/CamelWriterExercise/OhLand.txt");
        cw2.readLines();
    }

    public void readLines() throws FileNotFoundException {
        // Benyt en Scanner til at læse inFile én linje ad gangen
        // Kald convert2camel med hver linje.
        Scanner scanner = new Scanner(inFile);
        while (scanner.hasNextLine()) {
            convert2camel(scanner.nextLine());
        }
    }

    private void convert2camel(String line) throws ArrayIndexOutOfBoundsException {
        String[] words = line.split(" ");
        try {
            for (int i = 0; i < words.length; i++) {
                char[] chars = words[i].toCharArray();
                if (i == 0) {
                    chars[0] = Character.toLowerCase(chars[0]);
                } else {
                    chars[0] = Character.toUpperCase(chars[0]);
                }
                String newString = String.valueOf(chars);
                words[i] = newString;
            }
            String result = "";
            for (String str :
                    words) {
                result += str;
            }
            System.out.println(result);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        // Split line til et String[] af de enkelte ord i linjen
        // Konverter 1. ord til små og resten til stort begyndelsesbogstav
        // Sammensæt ordene til ét langt ord og udskriv.
    }

}
