package exceptions.exercise2;

public class Vehicle {
    // Empty constructor
    public Vehicle() {}

    // Method throws exception if speed > 90
    public void testSpeed(int speed) throws TooFastException {
        if (speed > 90) {
            throw new TooFastException(speed);
        }
        System.out.println("Speed " + speed + " is within limits.");
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle();

        // Call method with two different values and display stack trace
        try {
            System.out.println("Testing speed 80:");
            v.testSpeed(80);

            System.out.println("\nTesting speed 120:");
            v.testSpeed(120);
        } catch (TooFastException e) {
            e.printStackTrace();
        }
    }
}
