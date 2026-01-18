package io.exercise2;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String brand;
    private double price;
    private String description;
    private int stock;

    public Product(long id, String name, String brand, double price, String description, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    // Getters and toString for display
    public long getId() { return id; }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", brand=" + brand +
               ", price=" + price + ", description=" + description + ", stock=" + stock + "]";
    }
}
