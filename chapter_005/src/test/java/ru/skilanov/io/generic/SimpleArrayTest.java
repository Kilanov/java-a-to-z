package ru.skilanov.io.generic;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 * This is test class for SimpleArray class.
 */
public class SimpleArrayTest {

    /**
     * This is test method for adding string values.
     */
    @Test
    public void whenAddStringValueThenItAdded() {
        SimpleArray<String> array = new SimpleArray<>(4);
        array.add("test");
        array.add("newTest");
        String valueFirstIndex = "test";
        String valueSecondIndex = "newTest";

        Assert.assertThat(array.get(0), is(valueFirstIndex));
        Assert.assertThat(array.get(1), is(valueSecondIndex));
    }

    /**
     * This is test method for adding integer values.
     */
    @Test
    public void whenAddIntegerValueThenItAdded() {
        SimpleArray<Integer> array = new SimpleArray<>(4);
        array.add(1);
        array.add(2);
        int valueFirstIndex = 1;
        int valueSecondIndex = 2;

        Assert.assertThat(array.get(0), is(valueFirstIndex));
        Assert.assertThat(array.get(1), is(valueSecondIndex));
    }

    /**
     * This is test method for update string values.
     */
    @Test
    public void whenUpdateStringValueThenReturnChangedValue() {
        SimpleArray<String> array = new SimpleArray<>(4);
        array.add("test");
        array.add("newTest");
        array.update(0, "test2");
        array.update(1, "newTest2");
        String valueFirstIndexAfterFirstUpdate = "test2";
        String valueSecondIndexAfterFirstUpdate = "newTest2";

        Assert.assertThat(array.get(0), is(valueFirstIndexAfterFirstUpdate));
        Assert.assertThat(array.get(1), is(valueSecondIndexAfterFirstUpdate));

        array.update(0, "test3");
        array.update(1, "newTest3");
        String valueFirstIndexAfterSecondUpdate = "test3";
        String valueSecondIndexAfterSecondUpdate = "newTest3";

        Assert.assertThat(array.get(0), is(valueFirstIndexAfterSecondUpdate));
        Assert.assertThat(array.get(1), is(valueSecondIndexAfterSecondUpdate));
    }

    /**
     * This is test method for update integer values.
     */
    @Test
    public void whenUpdateIntegerValueThenReturnChangedValue() {
        SimpleArray<Integer> array = new SimpleArray<>(4);
        array.add(1);
        array.add(2);
        array.update(0, 2);
        array.update(1, 3);
        int valueFirstIndexAfterFirstUpdate = 2;
        int valueSecondIndexAfterFirstUpdate = 3;

        Assert.assertThat(array.get(0), is(valueFirstIndexAfterFirstUpdate));
        Assert.assertThat(array.get(1), is(valueSecondIndexAfterFirstUpdate));

        array.add(11);
        array.add(22);
        array.update(0, 22);
        array.update(1, 11);
        int valueFirstIndexAfterSecondUpdate = 22;
        int valueSecondIndexAfterSecondUpdate = 11;

        Assert.assertThat(array.get(0), is(valueFirstIndexAfterSecondUpdate));
        Assert.assertThat(array.get(1), is(valueSecondIndexAfterSecondUpdate));
    }

    /**
     * This is test method for deleting string values.
     */
    @Test
    public void whenDeleteStringValueThenItDeleted() {
        SimpleArray<String> array = new SimpleArray<>(4);
        array.add("test");

        array.delete(0);
        Assert.assertThat(array.get(0), is(0));
    }

    /**
     * This is test method for deleting integer values.
     */
    @Test
    public void whenDeleteIntegerValueThenReturnItDeleted() {
        SimpleArray<Integer> array = new SimpleArray<>(4);
        array.add(1);

        array.delete(0);
        Assert.assertThat(array.get(0), is(0));
    }
}
