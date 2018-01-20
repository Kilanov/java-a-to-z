package ru.skilanov.io.list;

/**
 * SimpleQueue class.
 *
 * @param <T> SimpleQueue
 */
public class SimpleQueue<T> extends SimpleLinkedList {
    /**
     * First node variable
     */
    private Node<T> first;
    /**
     * Last node variable
     */
    private Node<T> last;

    /**
     * Poll method.
     *
     * @return T
     */
    public T poll() {
        T temp = first.item;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    /**
     * Push method.
     *
     * @param value T
     */
    public void push(T value) {
        Node<T> node = new Node<>(value, null, null);
        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }
}
