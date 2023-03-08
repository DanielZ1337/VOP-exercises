package actor_details;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Actor {

    private String name;
    private int age;
    private boolean hasBeenInterviewed;

    public Actor(String name, int age, boolean hasBeenInterviewed) {
        this.name = name;
        this.age = age;
        this.hasBeenInterviewed = hasBeenInterviewed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasBeenInterviewed() {
        return hasBeenInterviewed;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hasBeenInterviewed=" + hasBeenInterviewed +
                '}' + System.lineSeparator();
    }

    public static void main(String[] args) throws IOException {
        Actor actor = new Actor("Ryan Reynolds", 46, false);
        Actor actor2 = new Actor("Leonardo DiCaprio", 48, false);
        Actor actor3 = new Actor("Tom Holland", 26, true);
        ArrayList<Actor> actors = new ArrayList<>(Arrays.asList(actor, actor2, actor3));
        System.out.println(actors);

        // Write to file
        try {
            Helpers.writeToFile(actors);
            Helpers.readFromFile("Exercises/practice_assignment2/Actors.txt");
            Helpers.checkHasBeenInterviewed("Exercises/practice_assignment2/Actors.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
