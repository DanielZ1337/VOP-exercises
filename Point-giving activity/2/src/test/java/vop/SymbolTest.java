package vop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymbolTest {
    @Test
    public void test_msft_file_is_loaded_correctly() {
        assertDoesNotThrow(() -> {
            Symbol stockLoader;
            stockLoader = (Symbol) Class.forName("vop.symbols.MSFT").getDeclaredConstructor().newInstance();
            assertEquals(85.949997d, stockLoader.priceAtTick(0));
            assertEquals(235.75d, stockLoader.priceAtTick(803));
            assertEquals(245.119995d, stockLoader.priceAtTick(1241));
        });

    }

    @Test
    public void test_goog_file_is_loaded_correctly()
    {
        assertDoesNotThrow(() -> {
            Symbol stockLoader;
            stockLoader = (Symbol) Class.forName("vop.symbols.GOOG").getDeclaredConstructor().newInstance();
            assertEquals(53.25d, stockLoader.priceAtTick(0));
            assertEquals(86.412003d, stockLoader.priceAtTick(756));
            assertEquals(90.25d, stockLoader.priceAtTick(1252));
        });

    }
}
