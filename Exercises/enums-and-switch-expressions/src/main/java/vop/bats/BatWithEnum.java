package vop.bats;

public class BatWithEnum {
    private String name;
    private PopulationStatus populationStatus;
    private FeedingGroups feedingGroups;

    public BatWithEnum(String name, PopulationStatus populationStatus, FeedingGroups feedingGroups) {
        this.name = name;
        this.populationStatus = populationStatus;
        this.feedingGroups = feedingGroups;
    }

    public String getName() {
        return name;
    }

    public PopulationStatus getPopulationStatus() {
        return populationStatus;
    }

    public FeedingGroups getFeedingGroups() {
        return feedingGroups;
    }

    @Override
    public String toString() {
        return name;
    }
}
