package threads.scenario1;

public class BankTest {
    public static void main(String[] args) {
        // Initial balance: 500
        BankAccount account = new BankAccount(500);

        // Client 1 withdraws 450, Client 2 withdraws 100
        Client c1 = new Client(account, "Client 1", 450);
        Client c2 = new Client(account, "Client 2", 100);

        c1.start();
        c2.start();

        // Wait for threads to finish to show final balance
        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
