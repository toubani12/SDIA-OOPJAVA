package threads.scenario1;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method prevents race condition
    public synchronized void withdraw(int amount, String clientName) {
        System.out.println(clientName + " attempts to withdraw " + amount);

        if (balance >= amount) {
            try {
                // Simulate processing time to provoke race condition if not synchronized
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance -= amount;
            System.out.println(clientName + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(clientName + " insufficient funds. Current balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}
