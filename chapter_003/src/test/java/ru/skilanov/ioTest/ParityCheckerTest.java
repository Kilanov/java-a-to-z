package ru.skilanov.ioTest;

import org.junit.Test;
import ru.skilanov.io.ParityChecker;

import java.io.ByteArrayInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * This test class checks ParityChecker.
 */
public class ParityCheckerTest {
    /**
     * This method should return true.
     */
    @Test
    public void whenSetNumThenReturnTrue() {
        ParityChecker checker = new ParityChecker();
        String number = "4";

        System.setIn(new ByteArrayInputStream(number.getBytes()));

        boolean result = checker.isNumber(System.in);
        assertThat(result, is(true));
    }

    /**
     * This method should return false.
     */
    @Test
    public void whenSetNumThenReturnFalse() {
        ParityChecker checker = new ParityChecker();
        String number = "5";

        System.setIn(new ByteArrayInputStream(number.getBytes()));

        boolean result = checker.isNumber(System.in);
        assertThat(result, is(false));
    }
}
