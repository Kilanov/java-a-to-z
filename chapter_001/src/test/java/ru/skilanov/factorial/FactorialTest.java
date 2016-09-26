package ru.skilanov.factorial;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    @Test
    public void whenSetFiveInCalculateThenReturnNumber() {
        Factorial factorial = new Factorial(5);
        int result = factorial.calculate();
        assertThat(result, is(120));
    }

    @Test(expected = Exception.class)
    public void whenSetNullInExistThenReturnException() throws Exception {
        Factorial factorial = new Factorial(0);
        factorial.exist();
    }

    @Test(expected = Exception.class)
    public void whenSetMinusInExistThenReturnException() throws Exception {
        Factorial factorial = new Factorial(-1);
        factorial.exist();
    }
}
