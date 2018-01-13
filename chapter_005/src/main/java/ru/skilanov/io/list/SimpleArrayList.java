package ru.skilanov.io.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is realization of ArrayList.
 *
 * @param <E> SimpleContainer
 */
public class SimpleArrayList<E> implements SimpleContainer<E> {

    /**
     * Array
     */
    Object[] container;
    /**
     * Size variable
     */
    int size = 0;
    /**
     * Modifications count variable
     */
    int modCount = 0;

    /**
     * Constructor.
     *
     * @param size int
     */
    public SimpleArrayList(int size) {
        this.container = new Object[]{size};
    }

    /**
     * Add method
     *
     * @param value E
     */
    @Override
    public void add(E value) {
        increaseSize(size + 1);
        container[size++] = value;
    }

    /**
     * Get method.
     *
     * @param index int
     * @return E
     */
    @Override
    public E get(int index) {
        return (E) container[index];
    }

    /**
     * Iterator of array.
     *
     * @return Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Method that increase size.
     *
     * @param size int
     */
    public void increaseSize(int size) {
        modCount++;
        int arraySize = container.length;
        if (size > arraySize) {
            int newSize = arraySize * 2;
            container = Arrays.copyOf(container, newSize);
        }
    }

    /**
     * Array iterator class.
     */
    public class ArrayListIterator implements Iterator<E> {
        /**
         * Index variable
         */
        int index = 0;
        /**
         * Expected modification variable
         */
        int expectedModCount = modCount;

        /**
         * Has next method.
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
            if (index >= size) {
                throw new NoSuchElementException();
            }
            return (E) container[index++];
        }

        /**
         * Check for modification method.
         */
        public void checkForMod() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
