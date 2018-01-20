package ru.skilanov.io.list;

/**
 * Stack class.
 *
 * @param <T> SimpleStack
 */
public class SimpleStack<T> extends SimpleLinkedList {
    /**
     * First node variable
     */
    private Node<T> first;

    /**
     * Poll method
     *
     * @return T
     */
    public T poll() {
        Node<T> temp = first;
        first = first.next;
        return temp.item;
    }

    /**
     * Push method
     *
     * @param value T
     */
    public void push(T value) {
        Node<T> node = new Node<>(value, null, null);
        node.next = first;
        first = node;
    }
}
