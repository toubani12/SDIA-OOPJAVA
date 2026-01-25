package threads.scenario2;

// Passenger extends Thread
public class Passenger extends Thread {
    private Bus bus;
    private int seatsNeeded;
    private String name;

    public Passenger(Bus bus, String name, int seatsNeeded) {
        this.bus = bus;
        this.name = name;
        this.seatsNeeded = seatsNeeded;
    }

    @Override
    public void run() {
        bus.bookSeats(seatsNeeded, name);
    }
}
