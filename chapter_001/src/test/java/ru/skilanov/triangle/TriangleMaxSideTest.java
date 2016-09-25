package ru.skilanov.triangle;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleMaxSideTest {
    @Test
    public void whenSetAnyNumsThenMaximumReturn() {
        TriangleMaxSide triangleMaxSide = new TriangleMaxSide();
        double maximum = triangleMaxSide.max(1.0, 2.0, 3.0);
        assertThat(maximum, is(3.0));
    }

    @Test
    public void whenSetSameNumsThenMaximumReturnIt() {
        TriangleMaxSide triangleMaxSide = new TriangleMaxSide();
        double maximum = triangleMaxSide.max(1.0, 1.0, 1.0);
        assertThat(maximum, is(1.0));
    }

    @Test
    public void whenSetMinusNumsThenMaximumReturn() {
        TriangleMaxSide triangleMaxSide = new TriangleMaxSide();
        double maximum = triangleMaxSide.max(-1.0, -2.0, -5.0);
        assertThat(maximum, is(-1.0));
    }
}
