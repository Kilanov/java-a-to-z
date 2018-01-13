package ru.skilanov.io.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;

/**
 * Test class for SimpleArrayList.
 */
public class SimpleArrayListTest {

    /**
     * Test of adding and getting values.
     */
    @Test
    public void whenWeAddValueAndGetItThenReturnRightResult() {
        SimpleArrayList list = new SimpleArrayList(10);
        list.add("1");
        list.add("2");

        Assert.assertThat(list.get(0), is("1"));
        Assert.assertThat(list.get(1), is("2"));
    }

    /**
     * Test of automatically increasing of array size.
     */
    @Test
    public void whenWeAddMoreValuesThenInListItAutomaticallyIncrease() {
        SimpleArrayList list = new SimpleArrayList(10);
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("11");
        list.add("12");
        Assert.assertThat(list.get(10), is("11"));
        Assert.assertThat(list.get(11), is("12"));
    }

    /**
     * Test of iterator.
     */
    @Test
    public void whenWeIterateListThenReturnsRightsValues() {
        SimpleArrayList list = new SimpleArrayList(10);
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator iterator = list.iterator();
        Assert.assertThat(iterator.next(), is("1"));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is("2"));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is("3"));
        Assert.assertFalse(iterator.hasNext());
    }

    /**
     * Test of iterator exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenWeIterateNotExistingValuesThenReturnException() {
        SimpleArrayList list = new SimpleArrayList(10);
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator iterator = list.iterator();
        Assert.assertThat(iterator.next(), is("1"));
        Assert.assertThat(iterator.next(), is("2"));
        Assert.assertThat(iterator.next(), is("3"));
        Assert.assertThat(iterator.next(), is("4"));
    }
}
