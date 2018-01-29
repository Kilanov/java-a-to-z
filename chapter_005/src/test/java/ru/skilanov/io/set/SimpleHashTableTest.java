package ru.skilanov.io.set;

import org.junit.Assert;
import org.junit.Test;

/**
 * SimpleHashTable class test.
 */
public class SimpleHashTableTest {

    /**
     * Checking add method.
     */
    @Test
    public void whenWeAddValuesThenReturnResult() {
        SimpleHashTable set = new SimpleHashTable();

        Assert.assertTrue(set.add("one"));
        Assert.assertFalse(set.add("one"));
        Assert.assertTrue(set.add("two"));
        Assert.assertTrue(set.add("zero"));
    }

    /**
     * Checking contains method.
     */
    @Test
    public void whenWeCheckIfArrayContainsValuesThenReturnRightResult() {
        SimpleHashTable set = new SimpleHashTable();

        set.add("one");
        set.add("two");

        Assert.assertTrue(set.contains("one"));
        Assert.assertTrue(set.contains("two"));
        Assert.assertFalse(set.contains("zero"));
    }

    /**
     * Checking remove method.
     */
    @Test
    public void whenWeRemoveValueThenReturnNull() {
        SimpleHashTable set = new SimpleHashTable();

        set.add("one");

        Assert.assertTrue(set.remove("one"));
        Assert.assertFalse(set.contains("one"));
    }
}
