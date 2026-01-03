import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un verbe du premier groupe: ");
        String verb = scanner.next().toLowerCase();

        if (verb.endsWith("er")) {
            String radical = verb.substring(0, verb.length() - 2);
            String[] pronouns = {"je", "tu", "il/elle", "nous", "vous", "ils/elles"};
            String[] endings = {"e", "es", "e", "ons", "ez", "ent"};

            for (int i = 0; i < pronouns.length; i++) {
                System.out.println(pronouns[i] + " " + radical + endings[i]);
            }
        } else {
            System.out.println("The verb must end in 'er'.");
        }
        scanner.close();
    }
}
