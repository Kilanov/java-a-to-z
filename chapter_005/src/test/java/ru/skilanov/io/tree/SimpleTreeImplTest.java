package ru.skilanov.io.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test class.
 */
public class SimpleTreeImplTest {


    /**
     * Iterator test.
     */
    @Test
    public void whenWeIterateItThenReturnTrue() {
        SimpleTreeImpl<Integer> tree = new SimpleTreeImpl<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        Iterator iterator = tree.iterator();

        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    /**
     * Add and find test class.
     */
    @Test
    public void when6ElFindLastThen6() {
        SimpleTreeImpl<Integer> tree = new SimpleTreeImpl<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     * Add and find test class.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        SimpleTreeImpl<Integer> tree = new SimpleTreeImpl<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }
}
