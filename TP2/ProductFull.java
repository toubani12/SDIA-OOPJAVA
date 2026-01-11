public class ProductFull {
    private long id;
    private String name;
    private String brand;
    private double price;
    private String description;
    private int stock;

    public ProductFull(long id, String name, String brand, double price, String description, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Name: " + name + ", Brand: " + brand + ", Price: " + price + ", Stock: " + stock + "]";
    }
}