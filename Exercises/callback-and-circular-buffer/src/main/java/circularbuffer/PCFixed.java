package circularbuffer;

public class PCFixed {
    public static void main(String[] args) throws InterruptedException {
        CircularBuffer buffer = new CircularBuffer(5);
        new Producer(buffer, 0);
        new Producer(buffer, 1);

        new Consumer(buffer, 0);
        new Consumer(buffer, 1);
        new Consumer(buffer, 2);

    }
}

