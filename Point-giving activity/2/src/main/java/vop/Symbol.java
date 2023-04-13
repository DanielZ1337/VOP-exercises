package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class Symbol {

    private List<Double> history = new ArrayList<>();
    private final String name;
    private final File historyFile;

    public Symbol(String name, File historyFile) {
        this.name = name;
        this.historyFile = historyFile;
        this.loadHistory();
    }

    public String getName() {
        return name;
    }

    public void loadHistory() {
        try {
            Scanner scanner = new Scanner(historyFile);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                history.add(Double.parseDouble(scanner.nextLine().split(",")[4]));
            }
        } catch (IOException e) {
            System.out.println("Could not load file");
        }
    }

    public double priceAtTick(int tick) {
        return history.get(tick);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
