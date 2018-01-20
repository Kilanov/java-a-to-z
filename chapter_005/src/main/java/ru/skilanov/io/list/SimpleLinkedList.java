package ru.skilanov.io.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is LinkedList class.
 *
 * @param <E> SimpleLinkedList
 */
public class SimpleLinkedList<E> implements SimpleContainer<E> {
    /**
     * Node first variable
     */
    private Node<E> first;
    /**
     * Node last variable
     */
    private Node<E> last;
    /**
     * Modification count variable
     */
    private int modCount = 0;
    /**
     * Size variable
     */
    private int size = 0;

    /**
     * Add method.
     *
     * @param value E
     */
    @Override
    public void add(E value) {
        modCount++;
        Node<E> firstNode = last;
        Node<E> lastNode = new Node<>(value, null, firstNode);
        last = lastNode;
        if (firstNode == null) {
            first = lastNode;
        } else {
            firstNode.next = lastNode;
        }
        size++;
    }

    /**
     * Get method.
     *
     * @param index int
     * @return E
     */
    @Override
    public E get(int index) {
        Node<E> node = first;
        if (index <= size && index >= 0) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node.item;
    }

    /**
     * Iterator method.
     *
     * @return Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Node class.
     *
     * @param <E> Node
     */
    private static class Node<E> {
        /**
         * E item variable
         */
        private E item;
        /**
         * Node next variable
         */
        private Node<E> next;
        /**
         * Node previous variable
         */
        private Node<E> previous;

        /**
         * Constructor
         *
         * @param item     E
         * @param next     Node
         * @param previous Node
         */
        public Node(E item, Node<E> next, Node<E> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    /**
     * Iterator for LinkedList.
     */
    public class LinkedListIterator implements Iterator<E> {
        /**
         *
         */
        private int expectedModCount = modCount;
        /**
         * Index variable
         */
        private int index = 0;
        /**
         * LastReturned variable
         */
        private Node<E> lastReturned;
        /**
         * Next variable
         */
        private Node<E> next = first;

        /**
         * HasNext method.
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return index != size;
        }

        /**
         * Next method.
         *
         * @return E
         */
        @Override
        public E next() {
            checkForMod();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            index++;
            return lastReturned.item;
        }

        /**
         * Check for modification.
         */
        public void checkForMod() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
