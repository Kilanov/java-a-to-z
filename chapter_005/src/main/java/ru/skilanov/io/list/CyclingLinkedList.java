package ru.skilanov.io.list;

/**
 * Cycling class.
 */
public class CyclingLinkedList {

    /**
     * Check if next node is cycling.
     *
     * @param first Node
     * @return boolean
     */
    boolean hasCycle(Node first) {
        boolean result = false;
        while (first.next != null) {
            result = true;
            break;
        }
        return result;
    }

    /**
     * Node class.
     *
     * @param <T> Node
     */
    public static class Node<T> {
        /**
         * Value variable
         */
        T value;
        /**
         * Next variable
         */
        Node<T> next;

        /**
         * Constructor.
         *
         * @param value T
         */
        public Node(T value) {
            this.value = value;
        }

        /**
         * Setter.
         *
         * @param next T
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

