package vop.bats;

public class Bat {
    private String name;
    private String populationStatus;
    private String feedingGroups;

    public Bat(String name, String populationStatus, String feedingGroups) {
        this.name = name;
        this.populationStatus = populationStatus;
        this.feedingGroups = feedingGroups;
    }

    public String getName() {
        return name;
    }

    public String getPopulationStatus() {
        return populationStatus;
    }

    public String getFeedingGroups() {
        return feedingGroups;
    }

    @Override
    public String toString() {
        return name;
    }
}
