package exceptions.exercise2;

public class TooFastException extends Exception {
    // Constructor calls super with specific message
    public TooFastException(int speed) {
        super("This is an exception of type TooFastException. Speed involved: " + speed);
    }
}
