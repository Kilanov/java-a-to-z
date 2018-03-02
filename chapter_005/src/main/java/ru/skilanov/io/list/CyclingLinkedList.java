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
    static <T> boolean hasCycle(Node<T> first) {
        boolean result = false;
        Node<T> currentNode = first;
        Node<T> nextNode;
        if (currentNode.next != null) {
            nextNode = currentNode.next;
            while (!result) {
                if (currentNode == nextNode) {
                    result = true;
                } else if (nextNode.next != null && nextNode.next.next != null) {
                    currentNode = currentNode.next;
                    nextNode = nextNode.next.next;
                }
            }
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

