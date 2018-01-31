package ru.skilanov.io.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;

/**
 * HashMap class tests.
 */
public class HashMapTest {

    /**
     * Insert method test.
     */
    @Test
    public void whenWeAddKeyAndValueThenReturnRightResult() {
        HashMap map = new HashMap();

        Assert.assertTrue(map.insert(1, "one"));
        Assert.assertFalse(map.insert(1, "two"));
    }

    /**
     * Get method test.
     */
    @Test
    public void whenWeGetKeysThenReturnRightResult() {
        HashMap map = new HashMap();
        map.insert(1, "one");

        Assert.assertThat(map.get(1), is("one"));
    }

    /**
     * Delete method test.
     */
    @Test
    public void whenWeDeleteThenReturnRightResult() {
        HashMap map = new HashMap();
        map.insert(1, "one");

        Assert.assertTrue(map.delete(1));
    }

    /**
     * Iterator method test.
     */
    @Test
    public void whenWeIterateItThenReturnRightResult() {
        HashMap map = new HashMap();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "three");
        map.insert(4, "four");

        Iterator iterator = map.iterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertFalse(iterator.hasNext());
    }
}
