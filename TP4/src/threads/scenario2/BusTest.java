package threads.scenario2;

public class BusTest {
    public static void main(String[] args) {
        // Total seats available: 3
        Bus bus = new Bus(3);

        // Two customers, each tries to book 2 seats
        Passenger p1 = new Passenger(bus, "Passenger 1", 2);
        Passenger p2 = new Passenger(bus, "Passenger 2", 2);

        p1.start();
        p2.start();

        try {
            p1.join();
            p2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Remaining seats: " + bus.getAvailableSeats());
    }
}
