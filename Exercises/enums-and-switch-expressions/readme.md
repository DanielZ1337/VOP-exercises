# Enums and Switch Expressions

This task is created to make you a bit more comfortable using enums and introduce you to switch expressions.

You may already have used the `switch` statement, however since JDK 12, Java allows you to use it as an expression as well - neat!

For instance, let's say we want to map a creature's type, ordinarily we would do something like this:
```java
String creature = "person";
String type = "";
switch (creature)
{
    case "person":
        type = "humanoid";
        break;
    case "chihuahua":
    case "bulldog":
        type = "canine";
        break;
    case "sword fish":
        type = "fish";
        break;
    default:
        throw new Exception("Invalid creature");
}
```

Using switch expressions we can rewrite it:

```java
String creature = "person";
String type = switch (creature) {
    case "person" -> "humanoid";
    case "chihuahua", "bulldog" -> "canine";
    case "sword fish" -> "fish";
    default -> throw new Exception("Invalid creature");
};
```

## The task

In this task we'll be working with Bats. `bats.Bats.all()` provides a list of bats with the following attributes:

- `name : String` - name of the bat
- `populationStatus : String` - The status of its population:
  - Increasing
  - Declining
  - Stable
  - Unknown
- `feedingGroups : String` - What food the bat eats:
  - Frugivore,
  - Insectivore,
  - Omnivore,
  - Sanguivore,
  - Nectarivore,
  - Carnivore

However, there is a problem; for some reason the original developer thought it would be a good idea to save `populationStatus` and `feedingGroups` as strings 😮.

As such, you are tasked with converting each bat in the list to an instance of `BatWithEnum` where the `populationStatus` and `feedingGroups` attributes have been switched out with appropriate enums.

### Task 1 - BatStatistics - convert

The `convert` method needs to be implemented. 
- Create a new `List<BatWithEnum>` local variable that can hold the new `BatWithEnum` instances you will be creating.
- Iterate over the parameter/list `bats` (the parameter referenced gets instantiated in the main method) and create a new instance of `BatWithEnum` for each of them
  - when creating a new `BatWithEnum` instance:
    - use a switch expression to set the `populationStatus` constructor parameter depending on which of the ENUMs correlate to the `populationStatus` of the current bats object
  
    - For the default case THROW an `InvalidPopulationStatusException` that is propagated  to the calling method (Do not handle the exception within the `convert` method).
    - use `FeedingGroups.valueOf(..)` to set the `feedingGroups` constructor parameter
- return the list from the method

If implemented correctly, you should be able to run the `main` method of the `BatStatistics`-class without getting any errors.

### Task 2 - BatStatistics - getPopulationStatusMap and getFeedingGroupsMap

Now that we have converted our `List<Bat>` to `List<BatWithEnum>`, we need to map them, such that it's easier to look up bats with a given `PopulationStatus` and `FeedingGroups`.

This will allow us to retrieve bats that are `Insectivore` and get a complete list of bats that fall under that category for example.

The procedure for `getPopulationStatusMap` and `getFeedingGroupsMap` are the same other the fact that you will be using different enums.

Implement `getPopulationStatusMap`:

- Create a local instance of  `Map<PopulationStatus, List<BatWithEnum>>` that holds the bats.
- Iterate over the list of bats in the `bats` parameter.
- For each bat, find the list of bats of the same type (hint: you can use `map.get(bat.getPopulationStatus())`) and save it to a local variable within your loop
    - The returned value from `map.get(bat.getPopulationStatus())` is going to be null during the first iteration of each type, as the list doesn't exist within the map. If that's the case you should create a new `ArrayList` for the bat Type (Hint: `map.put(<type>, new ArrayList<>())`)
    - Add the `BatWithEnum` instance to the Arraylist
    - Continue until you have mapped all bats
- return the map

Implement `getFeedingGroupsMap`:

- Create a local instance of  `Map<FeedingGroups, List<BatWithEnum>>` that holds the bats.
- Iterate over the list of bats in the `bats` parameter.
- For each bat, find the list of bats of the same type (hint: you can use `map.get(bat.getFeedingGroups())`) and save it to a local variable within your loop
    - The returned value from `map.get(bat.getFeedingGroups())` is going to be null during the first iteration of each type, as the list doesn't exist within the map. If that's the case you should create a new `ArrayList` for the bat Type (Hint: `map.put(<type>, new ArrayList<>())`)
    - Add the `BatWithEnum` instance to the Arraylist
    - Continue until you have mapped all bats
- return the map

To test your implementation uncomment the remaining part of the `main` method and run it.

If done correctly, you should get an output that starts like this:

```
The following bats are carnivorous:
 - Lyroderma lyra
 - Megaderma spasma
 - Mimon bennettii
 - Noctilio albiventris
 - Noctilio leporinus
 - Vampyrumspectrum

The following bats are declining in population:
 - Anoura cultrata
 - Aproteles bulmerae
 - Artibeus fraterculus
 - Austronomus australis
 - Balantiopteryx infusca
 - Balantiopteryx io
 - Barbastella barbastellus
 - Boneia bidens
 - Chaerephon bregullae
 - Chalinolobus dwyeri
 - Chalinolobus tuberculatus
 - Chilonatalus micropus
 - Chilonatalus tumidifrons
 - Coelops robinsoni
 - Coleura seychellensis
 - Corynorhinus mexicanus
 - Craseonycteris thonglongyai
 - Dobsonia chapmani
 - Dobsonia emersa
 - Dyacopterus rickarti
 - Dyacopterus spadiceus
...
```