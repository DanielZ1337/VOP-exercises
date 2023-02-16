import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class hashSet {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Geeks");
        hashSet.add("For");
        hashSet.add("Geeks");
        hashSet.add("GeeksforGeeks");

        Set<String> treeSet = new TreeSet<>();
        treeSet.addAll(hashSet);
        System.out.println(treeSet);
    }
}
