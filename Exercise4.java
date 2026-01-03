import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text (max 100 chars): ");
        String ch = scanner.nextLine().toUpperCase();

        int[] nb_occurrences = new int[26];

        for (char c : ch.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                nb_occurrences[c - 'A']++; // Maps 'A' to index 0, 'B' to 1, etc.
            }
        }

        System.out.println("The string contains:");
        for (int i = 0; i < 26; i++) {
            if (nb_occurrences[i] > 0) {
                char letter = (char) ('A' + i);
                System.out.println(nb_occurrences[i] + " occurrence(s) of the letter '" + letter + "'");
            }
        }
        scanner.close();
    }
}
