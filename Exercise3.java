import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Enter string");
            System.out.println("2. Display string");
            System.out.println("3. Reverse string");
            System.out.println("4. Number of words");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    text = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Stored: " + text);
                    break;
                case 3:
                    System.out.println("Reversed: " + new StringBuilder(text).reverse());
                    break;
                case 4:
                    // Splits by one or more spaces
                    String[] words = text.trim().split("\\s+");
                    System.out.println("Words: " + (text.isEmpty() ? 0 : words.length));
                    break;
            }
            if (choice != 5) {
                System.out.println("Press enter to return to the menu...");
                scanner.nextLine();
            }
        } while (choice != 5);
        scanner.close();
    }
}
