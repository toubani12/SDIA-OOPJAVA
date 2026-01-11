import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagementApp {
    private static final List<Product> products = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> addProduct();
                case "2" -> deleteByIndex();
                case "3" -> displayProducts();
                case "4" -> modifyByIndex();
                case "5" -> searchByName();
                case "6" -> exit = true;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        System.out.println("Exiting ProductManagementApp.");
    }

    private static void printMenu() {
        System.out.println("\nProduct Management:");
        System.out.println("1. Add product");
        System.out.println("2. Delete by index");
        System.out.println("3. Display products");
        System.out.println("4. Modify by index");
        System.out.println("5. Search by name");
        System.out.println("6. Exit");
        System.out.print("Choice: ");
    }

    private static void addProduct() {
        try {
            System.out.print("Enter id (long): ");
            long id = Long.parseLong(scanner.nextLine().trim());
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter price (double): ");
            double price = Double.parseDouble(scanner.nextLine().trim());
            products.add(new Product(id, name, price));
            System.out.println("Product added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Product not added.");
        }
    }

    private static void deleteByIndex() {
        System.out.print("Enter index to remove: ");
        try {
            int idx = Integer.parseInt(scanner.nextLine().trim());
            Product removed = products.remove(idx);
            System.out.println("Removed: " + removed);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of range.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid index.");
        }
    }

    private static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Products list:");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d: %s\n", i, products.get(i));
        }
    }

    private static void modifyByIndex() {
        System.out.print("Enter index to modify: ");
        try {
            int idx = Integer.parseInt(scanner.nextLine().trim());
            Product current = products.get(idx);
            System.out.println("Current: " + current);
            System.out.print("New id (or empty to keep): ");
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) current.setId(Long.parseLong(s));
            System.out.print("New name (or empty to keep): ");
            s = scanner.nextLine();
            if (!s.isBlank()) current.setName(s.trim());
            System.out.print("New price (or empty to keep): ");
            s = scanner.nextLine().trim();
            if (!s.isEmpty()) current.setPrice(Double.parseDouble(s));
            System.out.println("Product updated: " + current);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of range.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }

    private static void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().trim();
        boolean found = false;
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + p);
                found = true;
            }
        }
        if (!found) System.out.println("No product found with name '" + name + "'.");
    }
}