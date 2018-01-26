package ru.skilanov.io.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for CyclingLinkedList class.
 */
public class CyclingLinkedListTest {

    /**
     * Test that checks if node is cycling.
     */
    @Test
    public void whenWeStartCheckCyclingThenReturnRightResult() {
        CyclingLinkedList list = new CyclingLinkedList();
        CyclingLinkedList.Node first = new CyclingLinkedList.Node(1);
        CyclingLinkedList.Node two = new CyclingLinkedList.Node(2);
        CyclingLinkedList.Node three = new CyclingLinkedList.Node(3);
        CyclingLinkedList.Node four = new CyclingLinkedList.Node(4);

        first.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(first);

        Assert.assertTrue(list.hasCycle(first));
        Assert.assertTrue(list.hasCycle(two));
        Assert.assertTrue(list.hasCycle(three));
        Assert.assertTrue(list.hasCycle(four));
    }

    /**
     * Checking non cycling linked list.
     */
    @Test
    public void wheWeStartCheckNonCyclingThenReturnFalse() {
        CyclingLinkedList list = new CyclingLinkedList();
        CyclingLinkedList.Node first = new CyclingLinkedList.Node(1);
        CyclingLinkedList.Node two = new CyclingLinkedList.Node(2);
        CyclingLinkedList.Node three = new CyclingLinkedList.Node(3);
        CyclingLinkedList.Node four = new CyclingLinkedList.Node(4);

        first.setNext(two);
        two.setNext(three);
        three.setNext(four);

        Assert.assertFalse(list.hasCycle(four));
    }
}
