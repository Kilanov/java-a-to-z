package ru.skilanov.triangle;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenSetThreeDifferentPointsThenAreaReturn() {
        Triangle triangle = new Triangle(new Point(2, 1), new Point(3, 2), new Point(4, 3));
        double area = triangle.area();
        assertThat(area, is(closeTo(2,82)));
    }

    @Test
    public void whenSetThreeNullPointsThenAreaNull() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 0));
        double area = triangle.area();
        assertThat(area, is(0.0));
    }

    @Test
    public void whenSetThreeMinusPointsThenAreaNum() {
        Triangle triangle = new Triangle(new Point(-1, -2), new Point(-3, -4), new Point(-5, -6));
        double area = triangle.area();
        assertThat(area, is(closeTo(5,65)));
    }

    @Test(expected = Exception.class)
    public void whenSetWrongParametersInExistThenReturnException() throws Exception {
        Triangle triangle = new Triangle(new Point(1, 1), new Point(2, 3), new Point(1, 1));
        triangle.exists();
    }
}