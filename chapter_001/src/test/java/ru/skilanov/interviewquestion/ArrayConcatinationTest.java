package ru.skilanov.interviewquestion;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ArrayConcatinationTest {
    @Test
    public void whenSetFirstLessThanSecondArrayInConcatenationThenReturnSortedArray() {
        ArrayConcatination array = new ArrayConcatination();
        int[] one = new int[]{3, 2, 1};
        int[] two = new int[]{9, 8, 4};
        int[] result = array.concatination(one, two);
        int[] expected = new int[]{9, 8, 4, 3, 2, 1};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSetSecondLessThanFirstArrayInConcatenationThenReturnSortedArray() {
        ArrayConcatination array = new ArrayConcatination();
        int[] one = new int[]{9, 8, 4};
        int[] two = new int[]{3, 2, 1};
        int[] result = array.concatination(one, two);
        int[] expected = new int[]{9, 8, 4, 3, 2, 1};
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