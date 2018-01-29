package ru.skilanov.io.set;

import java.util.Arrays;

/**
 * Hash table class.
 *
 * @param <E> E
 */
public class SimpleHashTable<E> {
    /**
     * Constant variable of default array length
     */
    private static final int INITIAL_CAPACITY = 10;
    /**
     * Default array
     */
    private DataKey<E>[] dataKeys;
    /**
     * Size of array
     */
    private int size = 0;

    /**
     * Default constructor.
     *
     * @param initialCapacity int
     */
    public SimpleHashTable(int initialCapacity) {
        this.dataKeys = new DataKey[initialCapacity];
    }

    /**
     * Constructor that init size.
     */
    public SimpleHashTable() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Method where we get hash code of the value.
     *
     * @param e E
     * @return int
     */
    private int hash(E e) {
        int result = e.hashCode() % dataKeys.length;
        return result;
    }

    /**
     * Method increase size of the array.
     *
     * @param size int
     */
    private void increaseSize(int size) {
        int arraySize = dataKeys.length;
        if (size > arraySize) {
            int newSize = arraySize * 2;
            dataKeys = Arrays.copyOf(dataKeys, newSize);
        }
    }

    /**
     * Method that adds values and checks for duplicates.
     *
     * @param e E
     * @return boolean
     */
    public boolean add(E e) {
        boolean result = false;
        int hashKey = hash(e);
        increaseSize(size + 1);
        if (contains(e)) {
            return result;
        } else if (dataKeys[hashKey] == null) {
            dataKeys[hashKey] = new DataKey<>(e);
            size++;
            result = true;

        }
        return result;
    }

    /**
     * Get method.
     *
     * @param e E
     * @return E
     */
    public E get(E e) {
        int result = hash(e);
        return (E) dataKeys[result];
    }

    /**
     * Method that checks by hash code if value already in the array.
     *
     * @param e E
     * @return boolean
     */
    public boolean contains(E e) {
        boolean result = false;
        int hashKey = hash(e);
        if (dataKeys[hashKey] != null) {
            result = true;
        }
        return result;
    }

    /**
     * Method that removes values.
     *
     * @param e E
     * @return boolean
     */
    public boolean remove(E e) {
        boolean result = false;
        int hashKey = hash(e);
        if (dataKeys[hashKey] != null) {
            dataKeys[hashKey] = null;
            result = true;
        }
        return result;
    }

    /**
     * Class data key.
     *
     * @param <E> E
     */
    public class DataKey<E> {
        /**
         * Value variable
         */
        private E value;

        /**
         * Constructor
         *
         * @param value E
         */
        DataKey(E value) {
            this.value = value;
        }

        /**
         * Getter.
         *
         * @return E
         */
        public E getValue() {
            return value;
        }

        /**
         * Setter.
         *
         * @param value E
         */
        public void setValue(E value) {
            this.value = value;
        }
    }
}
