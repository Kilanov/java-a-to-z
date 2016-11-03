package ru.skilanov.interviewquestion;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ArrayConcatinationTest {
    @Test
    public void whenSetFirstLessThanSecondArrayInConcatenationThenReturnSortedArray() {
        ArrayConcatination array = new ArrayConcatination();
        int[] one = new int[]{1, 2, 3};
        int[] two = new int[]{4, 8, 9};
        int[] result = array.concatination(one, two);
        int[] expected = new int[]{1, 2, 3, 4, 8, 9};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSetSecondLessThanFirstArrayInConcatenationThenReturnSortedArray() {
        ArrayConcatination array = new ArrayConcatination();
        int[] one = new int[]{4, 8, 9};
        int[] two = new int[]{1, 2, 3};
        int[] result = array.concatination(one, two);
        int[] expected = new int[]{1, 2, 3, 4, 8, 9};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSetNullInConcatenationThenReturnNullArray() {
        ArrayConcatination array = new ArrayConcatination();
        int[] one = new int[]{0, 0, 0};
        int[] two = new int[]{0, 0, 0};
        int[] result = array.concatination(one, two);
        int[] expected = new int[]{0, 0, 0, 0, 0, 0};
        assertThat(result, is(expected));
    }
}