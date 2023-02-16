import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MountainSet {
    private final Set<Mountain> tree;

    public MountainSet() {
        tree = new TreeSet<>();
    }

    public static void main(String[] args) throws IOException {
        MountainSet mSet = new MountainSet();
        Scanner scanner = new Scanner(new File("Exercises/frencemountains/FrenchMountains.csv"));
        while (scanner.hasNextLine()) {
            Mountain mountain = mSet.mountainParser(scanner.nextLine().split(";"));
            mSet.getTree().add(mountain);
        }
        System.out.println(mSet.getTree());

        System.out.println("Sorted by range:");
        System.out.println(mSet.sortByRange(new MountainRangeComparator()));
    }

    public Set<Mountain> getTree() {
        return tree;
    }

    public Mountain mountainParser(String[] split) {
        return new Mountain(split[0], split[1], split[2], split[3], split[4], split[5]);
    }

    public Set<Mountain> sortByRange(Comparator<Mountain> comparator) {
        Set<Mountain> rangeTree = new TreeSet<>(comparator);
        rangeTree.addAll(tree);
        return rangeTree;
    }
}
