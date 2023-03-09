package threads;

public class RunnableDemo {

    public static void main(String[] args)
    {
        RunnableTask task1 = new RunnableTask("Task 1");
        RunnableTask task2 = new RunnableTask("Task 2");
        RunnableTask task3 = new RunnableTask("Task 3");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
