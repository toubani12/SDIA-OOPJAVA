import java.util.HashSet;
import java.util.Set;

public class SetOperationsApp {
    public static void main(String[] args) {
        Set<String> groupA = new HashSet<>();
        Set<String> groupB = new HashSet<>();

        groupA.add("badr");
        groupA.add("hafsa");
        groupA.add("yazid");

        groupB.add("hafsa");
        groupB.add("yazid");
        groupB.add("amine");

        System.out.println("Group A: " + groupA);
        System.out.println("Group B: " + groupB);

        // Intersection
        Set<String> intersection = new HashSet<>(groupA);
        intersection.retainAll(groupB);
        System.out.println("Intersection: " + intersection);

        // Union
        Set<String> union = new HashSet<>(groupA);
        union.addAll(groupB);
        System.out.println("Union: " + union);
    }
}