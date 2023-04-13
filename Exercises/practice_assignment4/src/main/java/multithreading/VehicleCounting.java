package multithreading;

public class VehicleCounting {
    private int counter;

    public VehicleCounting(int counter) {
        this.counter = counter;
    }

    public synchronized void incrementCounter() {
        counter++;
    }

    public synchronized void decrementCounter() {
        counter--;
    }

    public synchronized int getCounter() {
        return counter;
    }
}
