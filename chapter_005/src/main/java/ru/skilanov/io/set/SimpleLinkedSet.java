package ru.skilanov.io.set;

import ru.skilanov.io.list.SimpleLinkedList;

/**
 * SimpleLinkedSet class.
 *
 * @param <E> E
 */
public class SimpleLinkedSet<E> extends SimpleLinkedList<E> {
    /**
     * Add method.
     *
     * @param value E
     */
    @Override
    public void add(E value) {
        if (isExist(value)) {
            super.add(value);
        }
    }

    /**
     * Method that checks if value exist already.
     *
     * @param e E
     * @return boolean
     */
    public boolean isExist(E e) {
        boolean result = true;
        Node<E> node = first;
        while (node != null) {
            if (node.item.equals(e)) {
                result = false;
                break;
            } else {
                node = node.next;
            }
        }
        return result;
    }
}
