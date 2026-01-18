# PRACTICAL WORK REPORT: IO & EXCEPTION HANDLING

**Subject:** Object-Oriented Programming (Java)

**Student:** TOUBANI BADR EDDINE
**Academic Year:** 2025/2026

---

## Project Structure

```
TP3/
├── src/
│   ├── io/
│   │   ├── exercise1/
│   │   │   └── LSCommand.java
│   │   └── exercise2/
│   │       ├── Product.java
│   │       ├── IProduitMetier.java
│   │       ├── MetierProduitImpl.java
│   │       └── Application.java
│   └── exceptions/
│       ├── exercise1/
│       │   └── Calculator.java
│       └── exercise2/
│           ├── TooFastException.java
│           └── Vehicle.java
└── README.md
```

---

## PART 1: INPUT/OUTPUT (IO)

### Exercise 1: Simulation of the `ls` Command

#### 1. Objective

The goal is to develop a program that lists files and directories in a user-specified path. The output must differentiate between `<DIR>` and `<FILE>` and show permissions (read `r`, write `w`) and hidden status (`h`).

#### 2. Key Implementation Details

To solve this, I used the `java.io.File` class. The core logic iterates through the file array and constructs a status string based on file attributes.

**Code Snippet: Analyzing File Attributes**

```java
File directory = new File(path);
File[] contents = directory.listFiles();

for (File file : contents) {
    // Determine type: Directory or File
    String type = file.isDirectory() ? "<DIR>" : "<FILE>";

    // Determine permissions and hidden status
    String read = file.canRead() ? "r" : "-";
    String write = file.canWrite() ? "w" : "-";
    String hidden = file.isHidden() ? "h" : "-"; // 'h' for cache/hidden files

    // Format output: Path <TYPE> flags
    System.out.printf("%s %s %s%s%s%n", file.getAbsolutePath(), type, read, write, hidden);
}
```

#### 3. Execution Result

**Scenario:** Listing a project directory.

```text
Enter the full path to the directory: C:\Projects\TP_Java
C:\Projects\TP_Java\src <DIR> rw-
C:\Projects\TP_Java\.git <DIR> rwh
C:\Projects\TP_Java\README.txt <FILE> rw-
```

---

### Exercise 2: Product Serialization

#### 1. Objective

We must manage a list of products (Add, List, Search, Delete) and save them to a file named `products.dat` using serialization.

#### 2. Key Implementation Details

The solution requires two main components: the Serializable entity and the persistence logic.

**A. The Product Entity**

The class must implement `Serializable` so Java can convert the object state into a byte stream.

```java
import java.io.Serializable;

public class Product implements Serializable {
    // serialVersionUID ensures version compatibility during deserialization
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    // ... other attributes (brand, price, etc.)
}
```

**B. Saving Data (Serialization)**

I implemented the `saveAll()` method using `ObjectOutputStream`. This writes the entire `List<Product>` object to the file at once.

```java
@Override
public void saveAll() {
    // Try-with-resources ensures the stream closes automatically
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.dat"))) {
        oos.writeObject(products); // Writes the whole list
        System.out.println("Products saved successfully.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

**C. Loading Data (Deserialization)**

When the program starts, it attempts to read the list back into memory using `ObjectInputStream`.

```java
// Logic inside the MetierProduitImpl constructor
File file = new File("products.dat");
if (file.exists()) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
        products = (List<Product>) ois.readObject(); // Cast object back to List
    } catch (Exception e) {
        products = new ArrayList<>(); // Fallback if file is corrupt
    }
}
```

#### 3. Execution Result

**Scenario:** Adding a product and saving.

```text
3. Add a new product to the list
... (User enters Product ID 101, Name: Laptop) ...
Product added.

5. Save the products
Products saved successfully. (Data written to products.dat)
```

---

## PART 2: HANDLING EXCEPTIONS

### Exercise 1: Robust Calculator

#### 1. Objective

Create a calculator that handles specific runtime errors: Division by zero, invalid string-to-number conversion, and unsupported operators.

#### 2. Key Implementation Details

**A. Handling Division by Zero**

We manually check the denominator before dividing to prevent the standard `ArithmeticException` and print a custom error.

```java
public void divide(int a, int b) {
    if (b == 0) {
        System.out.println("Error: Division by zero not possible.");
    } else {
        System.out.println("Result: " + (a / b));
    }
}
```

**B. Handling Number Format**

We use a `try-catch` block to intercept `NumberFormatException` when parsing user input.

```java
public void convertToNumber(String text) {
    try {
        int number = Integer.parseInt(text);
        System.out.println("Converted: " + number);
    } catch (NumberFormatException e) {
        System.out.println("Error: '" + text + "' is not a valid number");
    }
}
```

#### 3. Execution Result

```text
Input: divide(10, 0) -> Output: Error: Division by zero not possible.
Input: convert("abc") -> Output: Error: 'abc' is not a valid number.
```

---

### Exercise 2: Custom Exceptions

#### 1. Objective

Create a custom exception `TooFastException` and throw it if a `Vehicle` exceeds a speed of 90.

#### 2. Key Implementation Details

**A. The Custom Exception**

This class extends `Exception` (making it a checked exception) and passes a specific message to the super constructor.

```java
public class TooFastException extends Exception {
    public TooFastException(int speed) {
        super("This is an exception of type TooFastException. Speed involved: " + speed);
    }
}
```

**B. Throwing the Exception**

In the `Vehicle` class, the `testSpeed` method declares that it *may* throw this exception using `throws`. The `throw` keyword is used when the logic condition (speed > 90) is met.

```java
public void testSpeed(int speed) throws TooFastException {
    if (speed > 90) {
        // Condition met: Throw the custom exception
        throw new TooFastException(speed);
    }
    System.out.println("Speed is OK.");
}
```

**C. Catching the Exception**

In the `main` method, we wrap the call in a try-catch block to display the stack trace.

```java
try {
    v.testSpeed(120);
} catch (TooFastException e) {
    e.printStackTrace(); // Prints the red error trace to console
}
```

#### 3. Execution Result

**Scenario:** Testing speed 120.

```text
exceptions.exercise2.TooFastException: This is an exception of type TooFastException. Speed involved: 120
    at exceptions.exercise2.Vehicle.testSpeed(Vehicle.java:10)
    at exceptions.exercise2.Vehicle.main(Vehicle.java:23)
```

---




## Conclusion

This practical work allowed us to master:

1. **File Manipulation:** Navigating directories and checking permissions programmatically.
2. **Persistence:** Using Java Serialization to store object graphs.
3. **Exception Handling:** Moving beyond standard errors to create domain-specific exceptions (like `TooFastException`) that enforce business rules.
