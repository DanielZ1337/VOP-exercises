package threads;

public class ThreadDemo {

    public static void main(String[] args)
    {
        Counter cr = new Counter();
        System.out.println(cr.getCounter());
        Task1 task1 = new Task1(cr);
        Task2 task2 = new Task2(cr);
        task1.start();
        task2.start();
        try {
            Thread.sleep(1000);
            System.out.println(cr.getCounter());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
