import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

public class StudentGradesApp {
    public static void main(String[] args) {
        Map<String, Double> grades = new HashMap<>();

        // Insertion
        grades.put("badr", 15.0);
        grades.put("ahmed", 12.0);
        grades.put("yazid", 18.0);
        System.out.println("Grades inserted: " + grades);

        // Increase a grade
        grades.computeIfPresent("badr", (k, v) -> v + 2);
        System.out.println("After increasing badr: " + grades);

        // Delete a grade
        grades.remove("ahmed");
        System.out.println("After removing ahmed: " + grades);

        // Size
        System.out.println("Map size: " + grades.size());

        // Average / Max / Min
        OptionalDouble avg = grades.values().stream().mapToDouble(Double::doubleValue).average();
        double max = grades.values().stream().mapToDouble(Double::doubleValue).max().orElse(Double.NaN);
        double min = grades.values().stream().mapToDouble(Double::doubleValue).min().orElse(Double.NaN);
        System.out.printf("Average: %.2f, Max: %.2f, Min: %.2f\n", avg.orElse(Double.NaN), max, min);

        // Check if any grade is 20
        boolean has20 = grades.containsValue(20.0);
        System.out.println("Is there a grade 20? " + (has20 ? "Yes" : "No"));

        // Display using forEach lambda
        System.out.println("All entries:");
        grades.forEach((name, grade) -> System.out.println(name + " = " + grade));
    }
}