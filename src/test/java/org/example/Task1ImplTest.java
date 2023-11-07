package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

class Task1ImplTest {

    private IStringRowsListSorter rowsListSorter;

    @BeforeEach
    void setUp() {
        rowsListSorter = Task1Impl.INSTANCE;
    }

    @Test
    void sort() {
        var expectedSortedRows = new CopyOnWriteArrayList<>(Arrays.asList(
                new String[]{"d", "a", null, "c"},
                new String[]{"d", "a", "", "2"},
                new String[]{"d", "a", "", "1"},
                new String[]{"d", "a", "1xxx2xxx222x45", "c"},
                new String[]{"d", "a", "1xxx1111xxx222x45", "c"},
                new String[]{"d", "a", "1xxx1111xxx222x45", "c"},
                new String[]{"d", "a", "1xxx1111xxx322x45", "c"},
                new String[]{"d", "a", "ago", null},
                new String[]{"d", "a", "black", "c"},
                new String[]{"d", "a", "black", "a"}));

        var unsorted = new CopyOnWriteArrayList<>(Arrays.asList(
                new String[]{"d", "a", "1xxx1111xxx222x45", "c"},
                new String[]{"d", "a", null, "c"},
                new String[]{"d", "a", "1xxx1111xxx222x45", "c"},
                new String[]{"d", "a", "ago", null},
                new String[]{"d", "a", "black", "c"},
                new String[]{"d", "a", "1xxx1111xxx322x45", "c"},
                new String[]{"d", "a", "1xxx2xxx222x45", "c"},
                new String[]{"d", "a", "black", "a"},
                new String[]{"d", "a", "", "2"},
                new String[]{"d", "a", "", "1"}));

        var actual = new CopyOnWriteArrayList<>(unsorted);

        rowsListSorter.sort(actual, 2);

        Assertions.assertArrayEquals(expectedSortedRows.toArray(), actual.toArray());
    }
}