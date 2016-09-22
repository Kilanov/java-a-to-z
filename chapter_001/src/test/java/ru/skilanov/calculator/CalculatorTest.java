package ru.skilanov.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void whenSetTwoinAddThenReturnFour() {
        Calculator calc = new Calculator();
	calc.add(2.0, 2.0);
	assertThat(calc.getResult(), is(4.0));
    }

    @Test
    public void whenSetTwoinSubstructThenReturnNull() {
        Calculator calc = new Calculator();
	calc.substruct(2.0, 2.0);
	assertThat(calc.getResult(), is(0.0));
    }

    @Test
    public void whenSetTwoinDivThenReturnOne() {
        Calculator calc = new Calculator();
	calc.div(2.0, 2.0);
	assertThat(calc.getResult(), is(1.0));
    }

    @Test
    public void whenSetTwoinMultipleThenReturnFour() {
        Calculator calc = new Calculator();
	calc.multiple(2.0, 2.0);
	assertThat(calc.getResult(), is(4.0));
    }
}