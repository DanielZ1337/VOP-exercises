package vop;

import vop.broker.*;

import java.util.HashMap;
import java.util.Map;

public class Account implements OpenForOrdersCallbackInterface {
    private String name;
    private double balance = 100_000d;
    private Map<Symbol, Integer> equities = new HashMap<>();

    public Account(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public Map<Symbol, Integer> getEquities() {
        return equities;
    }

    public void printBalance() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("### BALANCE: $").append(String.format("%.2f", balance)).append(" ###\r\n");
        equities.forEach((symbol, amount) -> stringBuilder.append(symbol.getName()).append(" -> ").append(amount).append("\r\n"));

        System.out.println(stringBuilder);
    }

    public synchronized void buy(Symbol symbol, int units) {
        Broker broker = Broker.getBroker();
        if (broker.isBusy()){
            try{
                wait();
            } catch(InterruptedException e){
                System.out.println("Thread is interrupted");
            }
        } else {
            Order order = new Order(symbol, units);
            try {
                broker.buy(order);
                updateBalance(order);
//                printBalance();
            } catch(BrokerBusyException e){
                System.out.println(e.getMessage());
            }
        }

    }

    public void updateBalance(Order order) {
        if(order.getStatus() == OrderStatus.Fulfilled){
            balance-=order.getPricePerUnit() *order.getUnits();
            if (!equities.containsKey(order.getSymbol())){
                equities.put(order.getSymbol(), 0);
            }
            equities.replace(order.getSymbol(), equities.get(order.getSymbol()) + order.getUnits());

        }
    }

    /*public static void main(String[] args) {
        Symbol goog = new vop.symbols.GOOG();
        Account account = new Account("Penguin Account");
        Broker.getBroker().addOpenForOrderSubscriber(account); // Uncomment in task 2.4
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    account.buy(goog, 5);
                    if (account.balance < 0) {
                        account.printBalance();
                        System.out.println("Balance depleted!");
                        System.exit(0);
                    }
                }

            }).start();
        }
    }*/


    @Override
    public synchronized void openForOrders() {
notify();
    }
}
