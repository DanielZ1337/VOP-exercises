package threads;

public class Task2 extends Thread {
    private Counter cr;

    public Task2(Counter cr) {
        this.cr = cr;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            cr.decrementCounter();
        }
    }
}
