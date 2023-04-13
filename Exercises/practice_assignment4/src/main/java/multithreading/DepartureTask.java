package multithreading;

public class DepartureTask implements Runnable{

    private VehicleCounting vc;

    public DepartureTask(VehicleCounting vc){
        this.vc = vc;
    }

    @Override
    public void run() {
        vc.decrementCounter();
    }
}
