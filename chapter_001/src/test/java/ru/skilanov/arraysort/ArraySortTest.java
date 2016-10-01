package ru.skilanov.arraysort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArraySortTest {
    @Test
    public void whenSetArrayInSortThenReturnSortedArray() {
        ArraySort arraySort = new ArraySort();
        int value[] = new int[]{-1, 5, 6, 0, 44, 56, 12, -900};
        int result[] = arraySort.sort(value);
        int expected[] = new int[]{-900, -1, 0, 5, 6, 12, 44, 56};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSetMinusInSortThenReturnSortedArray() {
        ArraySort arraySort = new ArraySort();
        int value[] = new int[]{-111, -2, -3, -11, -45, -65};
        int result[] = arraySort.sort(value);
        int expected[] = new int[]{-111, -65, -45, -11, -3, -2};
        assertThat(result, is(expected));
    }

}