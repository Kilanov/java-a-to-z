package ru.skilanov.arraysturning;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArraysTurningTest {
    @Test
    public void whenSetArrayInTurnArrayThenReturnTurnedArray() {
        ArraysTurning turning = new ArraysTurning();
        int[][] value = {{1, 2}, {3, 4}};
        int[][] result = turning.turnArray(value);
        int[][] expected = {{3, 1}, {4, 2}};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSetNullInTurnArrayThenReturnNullArray() {
        ArraysTurning turning = new ArraysTurning();
        int[][] value = {{0, 0}, {0, 0}};
        int[][] result = turning.turnArray(value);
        int[][] expected = {{0, 0}, {0, 0}};
        assertThat(result, is(expected));
    }
}
