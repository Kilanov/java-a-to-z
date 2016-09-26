package ru.skilanov.square;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenSetOneInCalculateThenReturnNine() {
        Square square = new Square(2, 3, 4);
        float result = square.calculate(1);
        assertThat(result, is(9.0F));
    }

    @Test
    public void whenSetTwoInCalculateThenReturnNineteen() {
        Square square = new Square(2, 3, 4);
        float result = square.calculate(2);
        assertThat(result, is(18.0F));
    }

    @Test
    public void whenSetNullInSquareThenReturnNull() {
        Square square = new Square(0, 0, 0);
        float result = square.calculate(1);
        assertThat(result, is(0.0F));
    }

    @Test
    public void whenSetMinusNumberInSquareThenReturnMinus() {
        Square square = new Square(-2, -3, -4);
        float result = square.calculate(1);
        assertThat(result, is(-9.0F));
    }

    @Test
    public void whenSetNullInSquareAndCalculateThenReturnNull() {
        Square square = new Square(0, 0, 0);
        float result = square.calculate(0);
        assertThat(result, is(0.0F));
    }
}