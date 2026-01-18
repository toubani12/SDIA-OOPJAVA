package io.exercise2;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        IProduitMetier metier = new MetierProduitImpl("products.dat");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Product Management Menu ---");
            System.out.println("1. Display the list of products");
            System.out.println("2. Search for a product by its ID");
            System.out.println("3. Add a new product to the list");
            System.out.println("4. Delete a product by ID");
            System.out.println("5. Save the products");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Product> list = metier.getAll();
                    if (list.isEmpty()) System.out.println("No products found.");
                    else list.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter ID to search: ");
                    long searchId = scanner.nextLong();
                    Product p = metier.findById(searchId);
                    if (p != null) System.out.println(p);
                    else System.out.println("Product not found.");
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter Stock: ");
                    int stock = scanner.nextInt();

                    metier.add(new Product(id, name, brand, price, desc, stock));
                    System.out.println("Product added.");
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    long delId = scanner.nextLong();
                    metier.delete(delId);
                    System.out.println("Product deleted (if it existed).");
                    break;
                case 5:
                    metier.saveAll();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
