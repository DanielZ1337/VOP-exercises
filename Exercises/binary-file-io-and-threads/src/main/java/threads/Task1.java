package threads;

public class Task1 extends Thread {
    private Counter cr;

    public Task1(Counter cr) {
        this.cr = cr;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            cr.incrementCounter();
        }
    }
}
