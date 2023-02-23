package binary_search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecursiveBinSearchTest {
    private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    @DisplayName("Testing recursive find can find index of number...")
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

    @DisplayName("Testing recursive find negative return when not found...")
    @Test
    void shouldReturnNegativeInsertionPointWhenNotFound() {
        for (int i = -1000; i < 1000; i++) {
            boolean numberExist = false;
            for (int no:
                 FIBOS) {
                if (no == i) {
                    numberExist = true;
                    break;
                }
            }
            if (!numberExist){
                assertTrue(RecursiveBinSearch.recursiveFind(FIBOS, i) < 0);
            }
        }
    }
}
