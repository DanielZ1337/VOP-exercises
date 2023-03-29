package circularbuffer;

public class Producer implements Runnable {
    private CircularBuffer buffer;
    private int initVal;

    public Producer(CircularBuffer buffer, int number) {
        this.buffer = buffer;
        initVal = number * 100;
        new Thread(this, "Producer_" + number).start();
    }

    public void run() {
        int i = initVal;
        while (true) {
            buffer.put(i++);
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}

