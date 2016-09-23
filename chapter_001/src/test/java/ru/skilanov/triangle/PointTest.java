package ru.skilanov.triangle;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void whenSetTwoInDistanceThenReturnNull() {
        Point point1 = new Point(2, 2);
        Point point2 = new Point(2, 2);
        double distance = point1.distanceTo(point2);
        assertThat(distance, is(0.0));
    }
}
