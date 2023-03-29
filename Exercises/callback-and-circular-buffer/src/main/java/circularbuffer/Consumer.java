package circularbuffer;

public class Consumer implements Runnable {

    private CircularBuffer buffer;

    public Consumer(CircularBuffer buffer, int number) {
        this.buffer = buffer;
        new Thread(this, "Consumer_" + number).start();
    }

    public void run() {
        while (true) {
            buffer.get();
            try {
                Thread.sleep((long) (Math.random() * 200));
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}
