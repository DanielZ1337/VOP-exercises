package vop.broker;

public class BrokerBusyException extends Exception{
    public BrokerBusyException(int maxTransactions)
    {
        super("The broker is busy with " + maxTransactions + " transactions");
    }
}
