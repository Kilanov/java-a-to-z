package ru.skilanov.finaltask;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FinalTaskTest {
    @Test
    public void whenSetTheSameStringInContainsThenReturnTrue() {
        FinalTask finalTask = new FinalTask();
        boolean result = finalTask.contains("abcd", "abcd");
        assertThat(result, is(true));
    }

    @Test
    public void whenSetDifferentStringInContainsThenReturnFalse() {
        FinalTask finalTask = new FinalTask();
        boolean result = finalTask.contains("abcd", "jk");
        assertThat(result, is(false));
    }

    @Test
    public void whenSetFirstShortAndSecondLongStringsInContainsThenReturnFalse() {
        FinalTask finalTask = new FinalTask();
        boolean result = finalTask.contains("abcd", "abcde");
        assertThat(result, is(false));
    }

    @Test
    public void whenSetTheSameFirstLongAndSecondShortStringsInContainsThenReturnTrue() {
        FinalTask finalTask = new FinalTask();
        boolean result = finalTask.contains("abcd", "ab");
        assertThat(result, is(true));
    }
}