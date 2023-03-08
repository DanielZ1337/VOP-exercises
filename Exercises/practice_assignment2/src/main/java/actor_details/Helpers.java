package actor_details;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Helpers {
    /**
     * Implement the method below so the contents of the object
     * are written to the file Actors.txt, in the root of the project.
     * if the file already exists overwrite it.
     *
     * @throws IOException
     */
    public static void writeToFile(ArrayList<Actor> actorList) throws IOException {
        FileWriter fileWriter = new FileWriter("Exercises/practice_assignment2/Actors.txt");
        for (Actor actor : actorList) {
            fileWriter.write(actor.toString());
        }

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method takes the name of the file as an argument, then prints the contents of the file to the
     * users screen.
     *
     * @throws IOException
     */
    public static void readFromFile(String inputFile) throws IOException {
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            try {
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method takes the name of the file as its argument and only prints
     * out the actors who have been interviewed
     *
     * @throws IOException
     */
    public static void checkHasBeenInterviewed(String inputFile) throws IOException {
        Scanner scanner = new Scanner(new File(inputFile));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("true"))
                System.out.println(line);
        }
        try {
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
