package ru.skilanov.io.list;

/**
 * This is interface.
 *
 * @param <E> SimpleContainer
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Add method.
     *
     * @param value E
     */
    void add(E value);

    /**
     * Get method.
     *
     * @param index int
     * @return E
     */
    E get(int index);
}
