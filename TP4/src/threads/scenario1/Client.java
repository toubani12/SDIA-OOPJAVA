package threads.scenario1;

// Client extends Thread as requested
public class Client extends Thread {
    private BankAccount account;
    private int amount;
    private String name;

    public Client(BankAccount account, String name, int amount) {
        this.account = account;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount, name); // Call withdraw method
    }
}
