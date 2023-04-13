package multithreading;

public class ArrivalTask implements Runnable {

    private VehicleCounting vc;

    public ArrivalTask(VehicleCounting vc) {
        this.vc = vc;
    }

    @Override
    public void run() {
        vc.incrementCounter();
    }
}
