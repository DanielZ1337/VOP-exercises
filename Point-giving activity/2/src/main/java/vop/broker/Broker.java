package vop.broker;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Broker implements Runnable {

    private AtomicInteger ticks = new AtomicInteger(0);
    private final Random random = new Random();
    private int threshold;
    private final int maxTransactions = 5;
    private int maxUnitsPerOrder = 5;
    private static Broker instance = null;
    private final List<OpenForOrdersCallbackInterface> openForOrderSubscribers = new ArrayList<>();
    private final AtomicInteger spaces = new AtomicInteger(5);
    private final List<PriceUpdateCallbackInterface> priceUpdateSubscribers = new ArrayList<>();

    private Broker() {
        this.threshold = 4;
        new Thread(this).start();
    }

    public synchronized static Broker getBroker() {
        if (instance == null)
            instance = new Broker();
        return instance;
    }

    /**
     * Produces side-effects
     *
     * @param order the order you'd like to place
     * @throws BrokerBusyException if the broker is currently busy attending to other orders.
     */
    public void buy(Order order) throws BrokerBusyException {
        if (isBusy())
            throw new BrokerBusyException(maxTransactions);
        if (order.getUnits() > maxUnitsPerOrder)
        {
            order.setStatus(OrderStatus.Rejected);
            return;
        }
        spaces.decrementAndGet();
        order.setStatus(random.nextInt(10) > threshold ? OrderStatus.Fulfilled : OrderStatus.Rejected);
        order.setPricePerUnit(order.getSymbol().priceAtTick(ticks.get()));
    }

    @SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
    @Override
    public void run() {
        int tickUpdate = 0;
        while (true) {
            try {
                Thread.sleep(50);
                tickUpdate++;
                if (tickUpdate == 20) {
                    int tick = ticks.incrementAndGet();
                    priceUpdateSubscribers.forEach(subscriber -> subscriber.priceUpdate(tick));
                    tickUpdate = 0;
                }
                if (ticks.get() % 2 == 0 && spaces.get() < maxTransactions) {
                    spaces.set(random.nextInt(3) + 1); // open for new order
                    openForOrderSubscribers.forEach(OpenForOrdersCallbackInterface::openForOrders);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addOpenForOrderSubscriber(OpenForOrdersCallbackInterface subscriber) {
        this.openForOrderSubscribers.add(subscriber);
    }

    public void addPriceUpdateSubscriber(PriceUpdateCallbackInterface subscriber) {
        this.priceUpdateSubscribers.add(subscriber);
    }

    public int getTicks() {
        return ticks.get();
    }

    public synchronized boolean isBusy() {
        return spaces.get() == 0;
    }

    public void setMaxUnitsPerOrder(int maxUnitsPerOrder) {
        this.maxUnitsPerOrder = maxUnitsPerOrder;
    }
}
