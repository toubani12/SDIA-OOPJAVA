package exceptions.exercise1;

public class Calculator {

    // Divide method handling division by zero
    public void divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero not possible.");
        } else {
            System.out.println("Result: " + (a / b));
        }
    }

    // Convert method handling number format exception
    public void convertToNumber(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + text + "' is not a valid number");
        }
    }

    // Calculate method handling unsupported operations
    public void calculate(String operation, int a, int b) {
        switch (operation) {
            case "+":
                System.out.println("Result: " + (a + b));
                break;
            case "-":
                System.out.println("Result: " + (a - b));
                break;
            case "*":
                System.out.println("Result: " + (a * b));
                break;
            case "/":
                divide(a, b);
                break;
            default:
                System.out.println("Error: Operation '" + operation + "' not supported");
        }
    }

    // Main for testing
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("--- Test Division ---");
        calc.divide(10, 2);
        calc.divide(10, 0);

        System.out.println("\n--- Test Conversion ---");
        calc.convertToNumber("123");
        calc.convertToNumber("abc");

        System.out.println("\n--- Test Calculate ---");
        calc.calculate("+", 5, 5);
        calc.calculate("&", 5, 5);
    }
}
