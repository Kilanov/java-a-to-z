package ru.skilanov.triangle;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenSetThreePointsThenAreaReturn() {
        Triangle triangle = new Triangle(new Point(2, 1), new Point(3, 2), new Point(4, 3));
        double area = triangle.area();
        assertThat(area, is(2.8284271247461903));
    }
}