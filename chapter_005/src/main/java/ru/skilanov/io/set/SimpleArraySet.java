package ru.skilanov.io.set;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array set class.
 *
 * @param <E>
 */
public class SimpleArraySet<E> implements SimpleSetContainer<E> {
    /**
     * Constant variable of default array length
     */
    public static final int INITIAL_CAPACITY = 10;
    /**
     * Default array
     */
    Object[] array;
    /**
     * Array's size
     */
    int size = 0;
    /**
     * Counter of an array modifications
     */
    int modCount = 0;

    /**
     * Constrictor.
     *
     * @param initialCapacity int
     */
    public SimpleArraySet(int initialCapacity) {
        this.array = new Object[initialCapacity];
    }

    /**
     * Constructor.
     */
    public SimpleArraySet() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Add method.
     *
     * @param e E
     */
    @Override
    public void add(E e) {
        modCount++;
        increaseSize(size + 1);
        if (isExist(e)) {
            array[size++] = e;
        }
    }

    /**
     * Get method.
     *
     * @param index
     * @return
     */
    public E get(int index) {
        return (E) array[index];
    }

    /**
     * Iterator of the array.
     *
     * @return E
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleSetIterator<>();
    }

    /**
     * Method that increase size of the array.
     *
     * @param size int
     */
    private void increaseSize(int size) {
        int oldSize = array.length;
        if (size > oldSize) {
            int newSize = oldSize * 2;
            array = Arrays.copyOf(array, newSize);
        }
    }

    /**
     * Method that checks if value already exists in the array.
     *
     * @param e E
     * @return boolean
     */
    private boolean isExist(E e) {
        boolean result = true;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Iterator class.
     *
     * @param <E> SimpleIterator
     */
    public class SimpleSetIterator<E> implements Iterator<E> {
        /**
         * Index variable
         */
        int index = 0;
        /**
         * Expected modification variable
         */
        int expectedModCount = modCount;

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
            checkForModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) array[index++];
        }

        /**
         * Method that checks modifications.
         */
        public void checkForModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
