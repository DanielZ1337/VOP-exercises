package binarystreams;

import java.io.*;
import java.util.Scanner;

public class WriteSpeciesFileAppendError {

    public static void main(String[] args) {
        String fileName = getFileName("Enter output file name.");

        File file = new File(fileName);
        if (file.exists()) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file, true)) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            }) {

                Species califCondor = new Species("Calif. Condor", 27, 0.02);
                outputStream.writeObject(califCondor);

                Species blackRhino = new Species("Black Rhino", 100, 1.0);
                outputStream.writeObject(blackRhino);

            } catch (IOException e) {
                System.err.println("Error opening output file " + file + ": " + e.getMessage());
                System.exit(0);
            }
        } else {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file, true)) {
            }) {

                Species califCondor = new Species("Calif. Condor", 27, 0.02);
                outputStream.writeObject(califCondor);

                Species blackRhino = new Species("Black Rhino", 100, 1.0);
                outputStream.writeObject(blackRhino);

            } catch (IOException e) {
                System.err.println("Error opening output file " + file + ": " + e.getMessage());
                System.exit(0);
            }
        }
        System.out.println("Records sent to file " + file + ".");
        System.out.println("Now let's reopen the file and echo the records.");

        Species readOne;
        int records = 0;
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(file))) {

            while (true) {  //Reads until EOF
                readOne = (Species) inputStream.readObject();
                System.out.println(readOne);
                System.out.println();
                records++;
            }
        } catch (EOFException eof) {
            System.out.println("Reading Done! " + records);

        } catch (IOException e) {
            System.err.println("Error opening input file "
                    + file + ": " + e.getMessage());
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }

    }

    private static String getFileName(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        String fileName = null;
        System.out.println(prompt);
        fileName = keyboard.next();

        return fileName;
    }
}
