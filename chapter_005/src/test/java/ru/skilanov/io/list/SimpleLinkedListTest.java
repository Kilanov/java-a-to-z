package ru.skilanov.io.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;

/**
 * Test class for SimpleLinkedList class.
 */
public class SimpleLinkedListTest {

    /**
     * Add and get test.
     */
    @Test
    public void whenWeAddItemsThenWeGetRightItems() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        Assert.assertThat(list.get(0), is("1"));
        Assert.assertThat(list.get(1), is("2"));
        Assert.assertThat(list.get(2), is("3"));
        Assert.assertThat(list.get(3), is("4"));
    }

    /**
     * Iterator test method.
     */
    @Test
    public void whenWeUseNextAndHasNextThenReturnRightResults() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        Iterator iterator = list.iterator();

        Assert.assertThat(iterator.next(), is("1"));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is("2"));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is("3"));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is("4"));
        Assert.assertFalse(iterator.hasNext());
    }
}
