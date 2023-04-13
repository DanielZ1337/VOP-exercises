package vop;

import org.junit.jupiter.api.Test;
import vop.broker.Order;
import vop.broker.OrderStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {

    private Symbol get_test_symbol()
    {
        return new Symbol("Test symbol", null) {
            @Override
            public void loadHistory() {

            }
        };
    }

    @Test
    public void test_fulfilled_order_updates_balance() {
        Account account = new Account("Test account");
        double balance = account.getBalance();
        Symbol symbol = get_test_symbol();
        Order order = new Order(symbol, 50);
        order.setPricePerUnit(17.5d);
        order.setStatus(OrderStatus.Fulfilled);
        account.updateBalance(order);

        assertEquals(balance - order.getUnits() * order.getPricePerUnit(), account.getBalance());
        assertEquals(50, (int) account.getEquities().get(symbol));
    }

    @Test
    public void test_rejected_order_does_not_update_the_balance()
    {
        Account account = new Account("Test account");
        double balance = account.getBalance();
        Symbol symbol = get_test_symbol();
        Order order = new Order(symbol, 50);
        order.setPricePerUnit(17.5d);
        order.setStatus(OrderStatus.Rejected);
        account.updateBalance(order);

        assertEquals(balance, account.getBalance());
        assertTrue(account.getEquities().get(symbol) == null || account.getEquities().get(symbol) == 0);
    }

    @Test
    public void test_placed_order_does_not_update_the_balance()
    {
        Account account = new Account("Test account");
        double balance = account.getBalance();
        Symbol symbol = get_test_symbol();
        Order order = new Order(symbol, 50);
        order.setPricePerUnit(17.5d);
        order.setStatus(OrderStatus.Placed);
        account.updateBalance(order);

        assertEquals(balance, account.getBalance());
        assertTrue(account.getEquities().get(symbol) == null || account.getEquities().get(symbol) == 0);
    }


}