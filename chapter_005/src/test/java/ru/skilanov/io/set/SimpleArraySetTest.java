package ru.skilanov.io.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;

/**
 * Test class for the SimpleArraySet class.
 */
public class SimpleArraySetTest {

    /**
     * Test method that checks adding of values also it checks adding of duplicate values.
     */
    @Test
    public void whenWeAddValuesAndDuplicateThenReturnRightResult() {
        SimpleArraySet set = new SimpleArraySet();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("1");

        Assert.assertThat(set.get(0), is("1"));
        Assert.assertThat(set.get(1), is("2"));
        Assert.assertThat(set.get(2), is("3"));
        Assert.assertNull(set.get(3));
    }

    /**
     * Method that checks Iterator's next and HasNext methods.
     */
    @Test
    public void whenWeIterateSetThenReturnsRightsValues() {
        SimpleArraySet set = new SimpleArraySet();
        set.add("1");
        set.add("2");
        set.add("3");

        Iterator iterator = set.iterator();
        Assert.assertThat(iterator.next(), is("1"));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is("2"));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is("3"));
        Assert.assertFalse(iterator.hasNext());
    }

    /**
     * Method that checks expected exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenWeIterateNotExistingValuesThenReturnException() {
        SimpleArraySet set = new SimpleArraySet();
        set.add("1");
        set.add("2");
        set.add("3");

        Iterator iterator = set.iterator();
        Assert.assertThat(iterator.next(), is("1"));
        Assert.assertThat(iterator.next(), is("2"));
        Assert.assertThat(iterator.next(), is("3"));
        Assert.assertThat(iterator.next(), is("4"));
    }
}
