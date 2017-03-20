package ru.skilanov.testTask2;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for Island class.
 */
public class IslandTest {

    /**
     * This is constant param.
     */
    public static final int VALUE = 5;

    /**
     * This test finds island square.
     */
    @Test
    public void wenSetIslandThenReturnIsland() {
        Island island = new Island();
        int[][] islandArr = {{1, 0, 1, 1, 0},
                {0, 0, 1, 1, 1}};
        int result = island.maxSizeIsland(islandArr);
        assertThat(result, is(VALUE));
    }

    /**
     * This test finds island square.
     */
    @Test
    public void wenSetNullIslandThenReturnNull() {
        Island island = new Island();
        int[][] islandArr = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        int result = island.maxSizeIsland(islandArr);
        assertThat(result, is(0));
    }
}
