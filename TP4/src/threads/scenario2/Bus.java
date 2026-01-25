package threads.scenario2;

public class Bus {
    private int availableSeats;

    public Bus(int seats) {
        this.availableSeats = seats;
    }

    // Synchronized method to manage shared resource
    public synchronized boolean bookSeats(int seatsRequested, String passengerName) {
        System.out.println(passengerName + " is trying to book " + seatsRequested + " seats. Available: " + availableSeats);

        if (availableSeats >= seatsRequested) {
            try {
                Thread.sleep(100); // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            availableSeats -= seatsRequested;
            System.out.println(passengerName + " successfully booked " + seatsRequested + " seats.");
            return true;
        } else {
            System.out.println(passengerName + " failed to book. Not enough seats.");
            return false;
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
