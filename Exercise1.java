import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        double[] grades = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

        // 1. Sort and display
        Arrays.sort(grades);
        System.out.println("Sorted grades: " + Arrays.toString(grades));

        // 2. Average
        double sum = 0;
        for (double g : grades) sum += g;
        System.out.println("Average: " + (sum / n));

        // 3. High/Low
        System.out.println("Lowest: " + grades[0]);
        System.out.println("Highest: " + grades[n - 1]);

        // 4. Count occurrences of a specific grade
        System.out.print("Enter a grade to search for: ");
        double search = scanner.nextDouble();
        int count = 0;
        for (double g : grades) if (g == search) count++;
        System.out.println("Number of students with grade " + search + ": " + count);
        scanner.close();
    }
}
