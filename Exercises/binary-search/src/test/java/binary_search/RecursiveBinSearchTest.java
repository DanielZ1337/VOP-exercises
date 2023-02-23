package binary_search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecursiveBinSearchTest {
    private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    @Test
    void shouldFindsIndexOfNumber() {
        Arrays.stream(FIBOS).forEach(i -> {
            assertTrue(RecursiveBinSearch.recursiveFind(FIBOS, i) > 0);
        });
        assertEquals(1, RecursiveBinSearch.recursiveFind(FIBOS, 1));
        assertEquals(1, RecursiveBinSearch.recursiveFind(FIBOS, 1));
        assertEquals(2, RecursiveBinSearch.recursiveFind(FIBOS, 2));
        assertEquals(3, RecursiveBinSearch.recursiveFind(FIBOS, 3));
        assertEquals(4, RecursiveBinSearch.recursiveFind(FIBOS, 5));
        assertEquals(5, RecursiveBinSearch.recursiveFind(FIBOS, 8));
        assertEquals(6, RecursiveBinSearch.recursiveFind(FIBOS, 13));
        assertEquals(7, RecursiveBinSearch.recursiveFind(FIBOS, 21));
        assertEquals(8, RecursiveBinSearch.recursiveFind(FIBOS, 34));
        assertEquals(9, RecursiveBinSearch.recursiveFind(FIBOS, 55));
    }

    @Test
    void shouldReturnNegativeInsertionPointWhenNotFound() {
        for (int i = -20; i < 100; i++) {
            int numberFound = i;
            for (int fibo : FIBOS) {
                if (numberFound == fibo) {
                    numberFound = 0;
                    break;
                }
            }

            if (numberFound == i) {
                assertTrue(RecursiveBinSearch.recursiveFind(FIBOS, i) < 0);
            }
        }
    }
}
