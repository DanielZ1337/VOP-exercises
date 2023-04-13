package vop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vop.broker.Broker;
import vop.broker.OpenForOrdersCallbackInterface;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuyStockTest {
    @Test
    public void test_concurrent_buy_stock()
    {
        final Symbol[] goog = {null};
        assertDoesNotThrow(() -> {
            goog[0] = (Symbol) Class.forName("vop.symbols.GOOG").getDeclaredConstructor().newInstance();
        });

        assertDoesNotThrow(() -> {
            Account account = new Account("Test Account");
            Broker.getBroker().addOpenForOrderSubscriber((OpenForOrdersCallbackInterface) account);
            Broker.getBroker().setMaxUnitsPerOrder(25);
            long startTime = System.currentTimeMillis();
            AtomicBoolean doneBuying = new AtomicBoolean(false);
            for (int i = 0; i < 2; i++) {
                new Thread(() -> {
                    boolean keepBuying = true;
                    while (keepBuying) {
                        account.buy(goog[0],25);
                        if (account.getBalance() < 0) {
                            account.printBalance();
                            keepBuying = false;
                            doneBuying.set(true);
                        }
                    }

                }).start();
            }
            while(true)
            {
                long elapsedTime = System.currentTimeMillis() - startTime;
                if (elapsedTime > 30_000)
                    Assertions.fail("Account buy timed-out after 30 seconds");
                if (doneBuying.get())
                {
                    if (elapsedTime < 1_000)
                        Assertions.fail("Account finishing buying too fast!");
                    int googStock = account.getEquities().get(goog[0]);
                    assertTrue(googStock > 1500 && googStock < 2500, "Account bought" + (googStock > 2500 ? " too many " : " too few") + " GOOG stock. Did you update the default balance? Expected between 1500 and 2500 GOOG units but you have " + googStock + "!");
                    break;
                }
            }
        });

    }
}
