package vop;


import vop.bats.*;
import vop.exceptions.InvalidPopulationStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatStatistics {

    public static List<BatWithEnum> convert(List<Bat> bats) throws InvalidPopulationStatusException {
        List<BatWithEnum> convertedBats = new ArrayList<>();
        bats.forEach(bat -> {
            convertedBats.add(new BatWithEnum(bat.getName(),
                    switch (bat.getPopulationStatus()) {
                        case "Increasing" -> PopulationStatus.Increasing;
                        case "Decreasing" -> PopulationStatus.Decreasing;
                        case "Stable" -> PopulationStatus.Stable;
                        case "Unknown" -> PopulationStatus.Unknown;
                        default -> {
                            try {
                                throw new InvalidPopulationStatusException();
                            } catch (InvalidPopulationStatusException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }, FeedingGroups.valueOf(bat.getFeedingGroups())));
        });
        return convertedBats;
    }

    public static Map<PopulationStatus, List<BatWithEnum>> getPopulationStatusMap(List<BatWithEnum> bats) {
        Map<PopulationStatus, List<BatWithEnum>> map = new HashMap<>();
        bats.forEach(bat -> {
            map.computeIfAbsent(bat.getPopulationStatus(), k -> new ArrayList<>());
            map.get(bat.getPopulationStatus()).add(bat);
        });
        return map;
    }

    public static Map<FeedingGroups, List<BatWithEnum>> getFeedingGroupsMap(List<BatWithEnum> bats) {
        Map<FeedingGroups, List<BatWithEnum>> map = new HashMap<>();

        bats.forEach(bat -> {
            map.computeIfAbsent(bat.getFeedingGroups(), k -> new ArrayList<>());
            map.get(bat.getFeedingGroups()).add(bat);
        });

        return map;
    }

    public static void main(String[] args) {

        try {
            List<Bat> bats = Bats.all();
            List<BatWithEnum> convertedBats = convert(bats);

            System.out.println("The following bats are carnivorous:");
            BatStatistics.getFeedingGroupsMap(convertedBats)
                    .get(FeedingGroups.Carnivore)
                    .forEach(x -> System.out.println(" - " + x.toString()));
            System.out.print("\n");
            System.out.println("The following bats are declining in population:");
            BatStatistics.getPopulationStatusMap(convertedBats)
                    .get(PopulationStatus.Decreasing)
                    .forEach(x -> System.out.println(" - " + x.toString()));

        } catch (InvalidPopulationStatusException e) {
            e.printStackTrace();
        }
    }

}
