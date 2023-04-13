package threads;

public class Counter {
    private int counter;

    public Counter() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        counter += 2;
    }

    public void decrementCounter() {
        counter--;
    }
}
