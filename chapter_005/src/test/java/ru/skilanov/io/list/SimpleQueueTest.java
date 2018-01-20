package ru.skilanov.io.list;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 * Test class for SimpleQueue.
 */
public class SimpleQueueTest {

    /**
     * Push and poll test method.
     */
    @Test
    public void whenWePushValueThenItPoll() {
        SimpleQueue queue = new SimpleQueue();
        queue.push("1");
        queue.push("2");
        queue.push("3");

        Assert.assertThat(queue.poll(), is("1"));
        Assert.assertThat(queue.poll(), is("2"));
        Assert.assertThat(queue.poll(), is("3"));
    }
}
