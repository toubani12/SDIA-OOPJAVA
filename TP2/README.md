# Laboratory Report: Collections & Generics (TP2)

**Subject:** Object Oriented Programming (Java)
**Student:** TOUBANI BADR EDDINE
**Field:** SDIA /ENSET MOHAMMEDIA
**Date:** 2026-01-11

## 1. Introduction

The objective of this practical work (TP) is to master the Java Collections Framework (Lists, Maps, Sets) and the concept of Generics. The lab is divided into two main parts: manipulating standard collections to manage data (products, grades) and creating custom generic structures to create reusable and type-safe code.

---

## 2. Part I: Collections & Streams

### Exercise 1: Lists (Product Management)

**Description:**
We developed an application to manipulate a list of objects using the `ArrayList` class.

* **Class Implementation:**
We created a `Product` class containing the attributes `id` (long), `name` (String), and `price` (double).

* **Main Application (`ProductManagementApp`):**
We implemented a main method to perform the following operations:
1. **Add:** New products are added to the `ArrayList`.
2. **Delete:** Products are removed using their index in the list.
3. **Display:** The application iterates through the list to print details of all products.
4. **Modify:** A product at a specific index is updated with new details.
5. **Search:** The user types a name, and the program scans the list to find the matching product.

**Execution/Output Example:**

```
> Products added.
> List: [ID: 1, Name: Laptop, Price: 1200.0]
> Searching for 'Laptop': Found!
> Removing index 0...
> List is empty.
```

### Exercise 2: Maps (Student Grades)

**Description:**
This exercise focuses on the `HashMap` collection to store key-value pairs where the key is the Student Name (String) and the value is the Grade (Double).

* **Operations Implemented:**
1. **Insertion:** Added student grades into the map.
2. **Update:** Increased specific student grades.
3. **Deletion:** Removed a student's record.
4. **Statistics:** Calculated the size of the map, as well as the Average, Maximum, and Minimum grades using Java Streams or iteration.
5. **Verification:** Checked if any student achieved a grade of 20.
6. **Display:** Used the `forEach` loop with a lambda expression to print all entries.

**Execution/Output Example:**

```
> Map Size: 3
> Grades: badr=15.0, ahmed=12.0, yazid=18.0
> Average: 15.0, Max: 18.0, Min: 12.0
> Is there a grade 20? No
```

### Exercise 3: Sets (Group Management)

**Description:**
We utilized `HashSet` to manage unique student names in two different groups, A and B.

* **Operations Implemented:**
1. **Populate:** Added names to `groupA` and `groupB`.
2. **Intersection:** Calculated the common students between the two groups using `retainAll()` or stream filtering.
3. **Union:** Calculated the combination of all unique students from both groups using `addAll()`.

**Execution/Output Example:**

```
> Group A: [badr, hafsa, yazid]
> Group B: [hafsa, yazid, amine]
> Intersection: [hafsa, yazid]
> Union: [badr, hafsa, yazid, amine]
```

---

## 3. Part II: Generics

### Exercise 1: Generic Storage

**Description:**
To understand type abstraction, we created a custom class `GenericStorage<T>` capable of storing elements of any type.

* **Implementation:**
  * **Attributes:** An internal `List<T> elements` to store data.
  * **Methods:** `addElement(T o)`, `removeElement(int index)`, `getElement(int index)`, and `getSize()`.

* **Testing:**
The `GenericApplication` class verified this behavior by storing `Integer`, `String`, and `Double` types in separate instances of `GenericStorage`, confirming that the logic holds regardless of the data type.

### Exercise 2: Generic Interface for Product Management

**Description:**
This real-world scenario applies generics to a business logic layer (Metier).

* **Product Entity:** Defined with expanded attributes: id, name, brand, price, description, and stock.

* **Generic Interface (`IMetier<T>`):**
Defined standard CRUD operations (`add`, `getAll`, `findById`, `delete`) abstractly using a generic type `T` .

* **Implementation (`MetierProduitImpl`):**
Implemented `IMetier<Product>`, concretizing `T` as `Product`. It manages an internal list of products.

* **Menu Application:**
A console-based menu allows the user to interact with the system:

1. Display list.
2. Search by ID.
3. Add product.
4. Delete by ID.
5. Exit.

**Execution/Output Example:**

```
1. Display list
2. Search by id
3. Add new product
4. Delete by id
5. Exit
Choice: 3
> Enter id: 101
> Enter name: Mouse
> Product added.

Choice: 1
> [ID: 101, Name: Mouse, Brand: Logitech, Price: 25.0, Stock: 10]
```

---

## 4. Conclusion

This practical work successfully demonstrated the power of the Java Collections Framework for managing data structures dynamically. Furthermore, implementing Generics allowed us to write flexible, reusable code that ensures type safety at compile time, which is essential for building scalable Java applications.
