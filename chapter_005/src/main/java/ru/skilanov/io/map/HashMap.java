package ru.skilanov.io.map;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements HashMapContainer {
    /**
     * Conatant variable of the array size
     */
    private static final int INITIAL_CAPACITY = 10;
    /**
     * Array
     */
    private Container<K, V>[] container;
    /**
     * Size of array
     */
    private int size;

    /**
     * Constructor.
     *
     * @param initialCapacity int
     */
    private HashMap(int initialCapacity) {
        this.container = new Container[initialCapacity];
    }

    /**
     * Constructor.
     */
    HashMap() {
        this(INITIAL_CAPACITY);
    }

    /**
     * This method get hashcode of the object.
     *
     * @param key Object
     * @return int
     */
    private int hash(@NotNull Object key) {
        int hashedKey = key.hashCode() % container.length;
        return hashedKey;
    }

    /**
     * This method increased size of the array.
     *
     * @param size int
     */
    private void increaseSize(int size) {
        int arraySize = container.length;
        if (size > arraySize) {
            int newSize = arraySize * 2;
            container = Arrays.copyOf(container, newSize);
        }
    }

    /**
     * This method inserts keys and values into our array if it doesn't consist already.
     *
     * @param key   Object
     * @param value Object
     * @return boolean
     */
    @Override
    public boolean insert(Object key, Object value) {
        boolean result = false;
        increaseSize(size + 1);
        int hashedKey = hash(key);
        if (container[hashedKey] != null) {
            return result;
        } else if (container[hashedKey] == null) {
            container[hashedKey] = new Container<>(hashedKey, key, value);
            size++;
            result = true;
        }
        return result;
    }

    /**
     * This method get values from the array.
     *
     * @param key Object
     * @return Object
     */
    @Override
    public Object get(Object key) {
        int hashedKey = hash(key);
        return container[hashedKey].getValue();
    }

    /**
     * This method delete.
     *
     * @param key Object
     * @return boolean
     */
    @Override
    public boolean delete(Object key) {
        boolean result = false;
        int hashedKey = hash(key);
        if (container[hashedKey] != null) {
            container[hashedKey] = null;
            result = true;
        }
        return result;
    }

    /**
     * Iterator method.
     *
     * @return Iterator
     */
    @Override
    public Iterator iterator() {
        return new HashMapIterator();
    }

    /**
     * Model class.
     *
     * @param <K> Object
     * @param <V> Object
     */
    public static class Container<K, V> {
        /**
         * hashedKey variable
         */
        private int hashedKey;
        /**
         * Key variable
         */
        private Object key;
        /**
         * Value variable
         */
        private Object value;

        /**
         * Default constructor.
         *
         * @param hashedKey int
         * @param key       Object
         * @param value     Object
         */
        Container(int hashedKey, Object key, Object value) {
            this.hashedKey = hashedKey;
            this.key = key;
            this.value = value;
        }

        /**
         * Getter.
         *
         * @return int
         */
        public int getHashedKey() {
            return hashedKey;
        }

        /**
         * Setter
         *
         * @param hashedKey int
         */
        public void setHashedKey(int hashedKey) {
            this.hashedKey = hashedKey;
        }

        /**
         * Getter.
         *
         * @return Object
         */
        public Object getKey() {
            return key;
        }

        /**
         * Setter.
         *
         * @param key Object
         */
        public void setKey(Object key) {
            this.key = key;
        }

        /**
         * Getter.
         *
         * @return Object
         */
        public Object getValue() {
            return value;
        }

        /**
         * Setter.
         *
         * @param value Object
         */
        public void setValue(Object value) {
            this.value = value;
        }
    }

    /**
     * Iterator class.
     */
    public class HashMapIterator implements Iterator {
        /**
         * Index variable
         */
        int index = 0;

        /**
         * HasNext method.
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return size != index;
        }

        /**
         * Next method.
         *
         * @return Object
         */
        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return container[index++];
        }
    }
}
