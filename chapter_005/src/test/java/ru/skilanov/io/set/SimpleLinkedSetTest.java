package ru.skilanov.io.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;

/**
 * SimpleLinkedSet test class.
 */
public class SimpleLinkedSetTest {

    /**
     * Method that checks Iterator's next and HasNext methods.
     */
    @Test
    public void whenWeIterateSetThenReturnsRightsValues() {
        SimpleLinkedSet set = new SimpleLinkedSet();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("1");

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
        SimpleLinkedSet set = new SimpleLinkedSet();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("1");

        Iterator iterator = set.iterator();
        Assert.assertThat(iterator.next(), is("1"));
        Assert.assertThat(iterator.next(), is("2"));
        Assert.assertThat(iterator.next(), is("3"));
        Assert.assertThat(iterator.next(), is("1"));
    }
}
