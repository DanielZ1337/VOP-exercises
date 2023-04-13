package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {

    public static void main (String [] args) {

          VehicleCounting vc= new VehicleCounting(5);
        System.out.println("No. of parked vehicles before arrival and departure=" + vc.getCounter());

        // Create Tasks
        ArrivalTask p1=new ArrivalTask(vc);
        ArrivalTask p2=new ArrivalTask(vc);
        DepartureTask p3=new DepartureTask(vc);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(p1);
        executor.execute(p2);
        executor.execute(p3);

        executor.shutdown();

        // Wait until all threads are finished
        while (!executor.isTerminated()) {
        }

        System.out.println("No. of parked vehicles after arrival and departure=" + vc.getCounter());
    }


}
