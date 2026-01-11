import java.util.List;
import java.util.Scanner;

public class MetierApplication {
    private static final MetierProduitImpl metier = new MetierProduitImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> displayList();
                case "2" -> searchById();
                case "3" -> addProduct();
                case "4" -> deleteById();
                case "5" -> exit = true;
                default -> System.out.println("Invalid choice.");
            }
        }
        System.out.println("Goodbye.");
    }

    private static void printMenu() {
        System.out.println("\n1. Display list");
        System.out.println("2. Search by id");
        System.out.println("3. Add new product");
        System.out.println("4. Delete by id");
        System.out.println("5. Exit");
        System.out.print("Choice: ");
    }

    private static void displayList() {
        List<ProductFull> all = metier.getAll();
        if (all.isEmpty()) {
            System.out.println("No products.");
        } else {
            all.forEach(System.out::println);
        }
    }

    private static void searchById() {
        System.out.print("Enter id: ");
        try {
            long id = Long.parseLong(scanner.nextLine().trim());
            ProductFull p = metier.findById(id);
            if (p == null) System.out.println("Product not found.");
            else System.out.println(p);
        } catch (NumberFormatException e) {
            System.out.println("Invalid id.");
        }
    }

    private static void addProduct() {
        try {
            System.out.print("Enter id (long): ");
            long id = Long.parseLong(scanner.nextLine().trim());
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter brand: ");
            String brand = scanner.nextLine().trim();
            System.out.print("Enter price (double): ");
            double price = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Enter description: ");
            String desc = scanner.nextLine().trim();
            System.out.print("Enter stock (int): ");
            int stock = Integer.parseInt(scanner.nextLine().trim());
            ProductFull p = new ProductFull(id, name, brand, price, desc, stock);
            metier.add(p);
            System.out.println("Product added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Product not added.");
        }
    }

    private static void deleteById() {
        System.out.print("Enter id to delete: ");
        try {
            long id = Long.parseLong(scanner.nextLine().trim());
            boolean ok = metier.delete(id);
            System.out.println(ok ? "Deleted." : "No product with that id.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid id.");
        }
    }
}