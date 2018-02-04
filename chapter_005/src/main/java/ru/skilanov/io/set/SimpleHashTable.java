package ru.skilanov.io.set;

/**
 * Hash table class.
 *
 * @param <E> E
 */
public class SimpleHashTable<E> {
    /**
     * Constant variable of default array length
     */
    private static final int INITIAL_CAPACITY = 16;
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
    private SimpleHashTable(int initialCapacity) {
        this.dataKeys = new DataKey[initialCapacity];
    }

    /**
     * Constructor that init size.
     */
    SimpleHashTable() {
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
        if (result < 0) {
            result = Math.abs(result);
        }
        return result;
    }

    /**
     * Method increase size of the array.
     *
     * @param newCapacity int
     */
    private void increaseSize(int newCapacity) {
        DataKey<E>[] oldTable = dataKeys;
        DataKey<E>[] newTable = new DataKey[newCapacity];
        transfer(newTable);
        dataKeys = newTable;
    }

    /**
     * Method that transfers indexes from old to new array.
     *
     * @param newTable DataKey
     */
    private void transfer(DataKey<E>[] newTable) {
        int oldTable = dataKeys.length;
        int index;
        for (int i = 0; i < oldTable; i++) {
            index = dataKeys[i].getValue().hashCode() % newTable.length;
            newTable[index] = dataKeys[i];
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
        if (size == dataKeys.length) {
            increaseSize(dataKeys.length * 2);
        }

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
        return (E) dataKeys[hash(e)];
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
