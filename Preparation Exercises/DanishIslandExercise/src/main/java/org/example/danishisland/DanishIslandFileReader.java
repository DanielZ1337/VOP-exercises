package org.example.danishisland;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DanishIslandFileReader {

    private final File inFile;
    private List<DanishIsland> islandList;

    public DanishIslandFileReader(String fName) {
        inFile = new File(fName);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new File(".").getAbsolutePath());
        DanishIslandFileReader fr = new DanishIslandFileReader("Preparation Exercises/DanishIslandExercise/Islands punktum.txt");
        //DanishIslandFileReader fr = new DanishIslandFileReader("Islands komma.txt");
        fr.readFile();


        System.out.println("Result:\n" + fr.getList());

    }

    private void readFile() throws FileNotFoundException {
        islandList = new ArrayList<DanishIsland>();
        Scanner scan = null;
        String line;
        String[] tokens;

        String name = "";
        double circ;
        double area;
        int addr;
        int adkm;
        Scanner scanner = new Scanner(inFile);
        while (scanner.hasNextLine()) {
            String[] strings = scanner.nextLine().split(" ");
            name = strings[0];
            circ = Double.parseDouble(strings[1]);
            area = Double.parseDouble(strings[2]);
            addr = Integer.parseInt(strings[3]);
            adkm = Integer.parseInt(strings[4]);
            islandList.add(new DanishIsland(name, circ, area, addr, adkm));
        }
        scanner.close();

        // OPGAVEN:
        // Laes filen en linje ad gangen. Split linjen paa mellemrums tegnet.
        // Konverter de enkelte vaerdier til typerne der skal bruges i DanishIsland.
        // Opret et objekt for hver linje og tilfoej det til listen.
        // Vaer omhyggelig med at fange exceptions og faa lukke Scanner og fil

    }

    public List<?> getList() {
        return islandList;
    }


}

