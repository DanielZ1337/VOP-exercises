package binarystreams;

import java.io.Serializable;

/**
 * Serialized class for data on endangered species.
 */
public class Species implements Serializable {
    private String name;
    private int population;
    private double growthRate;


    public Species() {
        this(null, 0, 0);
    }


    public Species(String initialName, int initialPopulation,
                   double initialGrowthRate) {
        name = initialName;
        if (initialPopulation >= 0)
            population = initialPopulation;
        else {
            System.out.println("ERROR: Negative population.");
            System.exit(0);
        }
        growthRate = initialGrowthRate;
    }


    public String toString() {
        return ("Name = " + name + "\n"
                + "Population = " + population + "\n"
                + "Growth rate = " + growthRate + "%");
    }

}
