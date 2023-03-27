package circularbuffer;

import java.util.Arrays;

public class CircularBuffer {
    private Integer[] buffer;
    private int size;
    private int putIndex = 0;
    private int getIndex = 0;

    public CircularBuffer(int size) {
        buffer = new Integer[size];
        this.size = size;
    }

    synchronized int get() {
        System.out.println(Thread.currentThread().getName() + "\tGot: " + getIndex + ": " + buffer[getIndex]);
        if (buffer[getIndex] == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int val = buffer[getIndex];
        buffer[getIndex] = null;
        getIndex++;
        getIndex%=size;
        notify();
        return val;
    }

    synchronized void put(int n) {
        System.out.println(Thread.currentThread().getName() + " Put: " + putIndex + ": " + n);
        if (buffer[putIndex] == null) {
            buffer[putIndex] = n;
            putIndex++;
            putIndex%=size;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
    }


    public String toString() {
        return "Buff: " + Arrays.toString(buffer);
    }
}


