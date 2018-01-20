package ru.skilanov.io.list;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 * Test class for stack.
 */
public class SimpleStackTest {

    /**
     * Push and poll test method.
     */
    @Test
    public void whenWePushValueThenItPoll() {
        SimpleStack stack = new SimpleStack();
        stack.push("1");
        stack.push("2");
        stack.push("3");

        Assert.assertThat(stack.poll(), is("3"));
        Assert.assertThat(stack.poll(), is("2"));
        Assert.assertThat(stack.poll(), is("1"));
    }
}
