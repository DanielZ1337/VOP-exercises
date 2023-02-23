package binary_search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IterativeBinSearchTest {
    private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    @DisplayName("Testing iterative find can find index of number...")
    @Test
    void shouldFindsIndexOfNumber() {
        Arrays.stream(FIBOS).forEach(i -> {
            assertTrue(IterativeBinSearch.find(FIBOS, i) > 0);
        });
        assertEquals(1, IterativeBinSearch.find(FIBOS, 1));
        assertEquals(1, IterativeBinSearch.find(FIBOS, 1));
        assertEquals(2, IterativeBinSearch.find(FIBOS, 2));
        assertEquals(3, IterativeBinSearch.find(FIBOS, 3));
        assertEquals(4, IterativeBinSearch.find(FIBOS, 5));
        assertEquals(5, IterativeBinSearch.find(FIBOS, 8));
        assertEquals(6, IterativeBinSearch.find(FIBOS, 13));
        assertEquals(7, IterativeBinSearch.find(FIBOS, 21));
        assertEquals(8, IterativeBinSearch.find(FIBOS, 34));
        assertEquals(9, IterativeBinSearch.find(FIBOS, 55));
    }

    @DisplayName("Testing iterative find negative return when not found...")
    @Test
    void shouldReturnNegativeInsertionPointWhenNotFound() {
        for (int i = 0; i < 100; i++) {
            int numberFound = i;
            for (int fibo : FIBOS) {
                if (numberFound == fibo) {
                    numberFound = 0;
                    break;
                }
            }

            if (numberFound == i) {
                assertTrue(IterativeBinSearch.find(FIBOS, i) < 0);
            }
        }
    }
}
