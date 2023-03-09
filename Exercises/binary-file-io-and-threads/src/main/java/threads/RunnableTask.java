package threads;

public class RunnableTask implements Runnable {

    private int sum;
    private final String threadName;

    public RunnableTask(String threadName) {
        sum = 0;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sum += i;
            System.out.println("Thread: " + threadName + " Current Value: " + sum);
        }
        System.out.println("Thread: " + threadName + " Sum: " + sum);
    }
}
