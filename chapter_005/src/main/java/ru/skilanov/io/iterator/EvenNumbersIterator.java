package ru.skilanov.io.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is even number iterator class.
 */
public class EvenNumbersIterator implements Iterator {
    /**
     * This is array
     */
    private final int[] values;
    /**
     * This is variable
     */
    private int index = 0;

    /**
     * This is constructor.
     *
     * @param values int[]
     */
    public EvenNumbersIterator(int[] values) {
        this.values = values;
    }

    /**
     * This is hasNext method for even numbers.
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Tjis is next method for even numbers.
     *
     * @return Object
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (values[index] % 2 != 0) {
            index++;
        }

        return values[index++];
    }
}
