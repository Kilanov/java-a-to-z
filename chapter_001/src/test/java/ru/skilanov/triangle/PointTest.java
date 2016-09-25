package ru.skilanov.triangle;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void whenSetSamePointsInDistanceThenReturnNull() {
        Point point1 = new Point(2, 2);
        Point point2 = new Point(2, 2);
        double distance = point1.distanceTo(point2);
        assertThat(distance, is(0.0));
    }

    @Test
    public void whenSetDifferentPointsThenReturnNum() {
        Point point1 = new Point(2, 2);
        Point point2 = new Point(3, 3);
        double distance = point1.distanceTo(point2);
        assertThat(distance, is(1.4142135623730951));
    }

    @Test
    public void whenSetMinusNumberThenReturnNum() {
        Point point1 = new Point(-1, -2);
        Point point2 = new Point(1, 2);
        double distance = point1.distanceTo(point2);
        assertThat(distance, is(4.47213595499958));
    }

    @Test
    public void whenSetNullPointsThenReturnNull() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        double distance = point1.distanceTo(point2);
        assertThat(distance, is(0.0));
    }
}