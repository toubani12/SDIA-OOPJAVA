package io.exercise1;

import java.io.File;
import java.util.Scanner;

public class LSCommand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. User enters the full path
        System.out.print("Enter the full path to the directory: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] contents = directory.listFiles();

            if (contents != null) {
                for (File file : contents) {
                    // 2. Display <DIR> or <FILE>
                    String type = file.isDirectory() ? "<DIR>" : "<FILE>";

                    // 3. Determine access modes (r, w, h)
                    String read = file.canRead() ? "r" : "-";
                    String write = file.canWrite() ? "w" : "-";
                    // Using isHidden() to represent 'h' (cache/hidden)
                    String hidden = file.isHidden() ? "h" : "-";

                    // 4. Display in the format specified
                    System.out.printf("%s %s %s%s%s%n",
                        file.getAbsolutePath(),
                        type,
                        read,
                        write,
                        hidden
                    );
                }
            }
        } else {
            System.out.println("The specified path does not exist or is not a directory.");
        }

        scanner.close();
    }
}
