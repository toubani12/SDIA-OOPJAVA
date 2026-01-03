# OOPJAVA-TP1: Practical Exercises Report

This document serves as a report for the first practical work (TP1) in Object-Oriented Programming with Java. It covers four exercises focusing on basic Java syntax, arrays, string manipulation, and user input handling.

## Exercise 1: Student Grades Management

### Description
This program is designed to manage student grades. It prompts the user to enter the number of students and their respective grades. Once the data is collected, the program performs the following operations:
1.  **Sorting:** Sorts the grades in ascending order using `Arrays.sort()`.
2.  **Average Calculation:** Computes the average grade.
3.  **Extremes:** Identifies and displays the lowest and highest grades.
4.  **Search:** Counts how many students received a specific grade entered by the user.

### Key Concepts
*   `Scanner` for user input.
*   Array manipulation and traversal.
*   `Arrays` utility class.

### Execution Result
```
Enter the number of students: 3
Grade for student 1: 10
Grade for student 2: 15
Grade for student 3: 12
Sorted grades: [10.0, 12.0, 15.0]
Average: 12.333333333333334
Lowest: 10.0
Highest: 15.0
Enter a grade to search for: 12
Number of students with grade 12.0: 1
```

## Exercise 2: French Verb Conjugator

### Description
This program conjugates regular French verbs of the first group (those ending in "-er") in the present indicative tense. The user inputs a verb, and the program checks if it ends with "er". If valid, it removes the suffix to get the radical and appends the correct endings ("e", "es", "e", "ons", "ez", "ent") for each subject pronoun.

### Key Concepts
*   String manipulation methods (`endsWith`, `substring`).
*   Using arrays to store pronouns and endings for iteration.
*   Conditional logic.

### Execution Result
```
Entrez un verbe du premier groupe: chanter
je chante
tu chantes
il/elle chante
nous chantons
vous chantez
ils/elles chantent
```

## Exercise 3: String Operations Menu

### Description
An interactive console application that presents a menu to the user for performing various operations on a string. The features include:
1.  Entering a new string.
2.  Displaying the current string.
3.  Reversing the string.
4.  Counting the number of words in the string.
5.  Exiting the program.

The program runs in a loop, allowing multiple operations until the exit option is selected.

### Key Concepts
*   Control flow using `do-while` loops and `switch` statements.
*   `StringBuilder` for efficient string modification (reversing).
*   Regular expressions (`split("\\s+")`) for parsing words.

### Execution Result
```
--- MENU ---
1. Enter string
2. Display string
3. Reverse string
4. Number of words
5. Exit
Choice: 1
Enter text: Hello World
Press enter to return to the menu...

--- MENU ---
1. Enter string
2. Display string
3. Reverse string
4. Number of words
5. Exit
Choice: 2
Stored: Hello World
Press enter to return to the menu...

--- MENU ---
1. Enter string
2. Display string
3. Reverse string
4. Number of words
5. Exit
Choice: 3
Reversed: dlroW olleH
Press enter to return to the menu...

--- MENU ---
1. Enter string
2. Display string
3. Reverse string
4. Number of words
5. Exit
Choice: 4
Words: 2
Press enter to return to the menu...

--- MENU ---
1. Enter string
2. Display string
3. Reverse string
4. Number of words
5. Exit
Choice: 5
```

## Exercise 4: Letter Occurrence Counter

### Description
This program analyzes a line of text entered by the user (up to 100 characters) to count the frequency of each letter of the alphabet. It treats the input as case-insensitive (converting to uppercase) and uses an integer array of size 26 to track the count of each letter from 'A' to 'Z'.

### Key Concepts
*   Character arithmetic (e.g., `c - 'A'` to map letters to array indices).
*   Iterating through characters in a string.
*   Frequency counting using arrays.

### Execution Result
```
Enter a line of text (max 100 chars): Hello World
The string contains:
1 occurrence(s) of the letter 'D'
1 occurrence(s) of the letter 'E'
1 occurrence(s) of the letter 'H'
3 occurrence(s) of the letter 'L'
2 occurrence(s) of the letter 'O'
1 occurrence(s) of the letter 'R'
1 occurrence(s) of the letter 'W'
```

## Conclusion
These exercises provided hands-on experience with fundamental Java programming concepts, including data structures like arrays and strings, control flow mechanisms, and standard input/output operations.
