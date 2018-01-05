package ru.skilanov.io.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is prime iterator class.
 */
public class PrimeIterator implements Iterator {
    /**
     * This is array
     */
    private final int[] values;
    /**
     * This is variable
     */
    private int index = 0;

    /**
     * This is constructor
     *
     * @param values int[]
     */
    PrimeIterator(int[] values) {
        this.values = values;
    }

    /**
     * This is hasNext method.
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < values.length; i++) {
            if (isSimple(values[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * This is next method.
     *
     * @return Object
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (!isSimple(values[index])) {
            this.index++;
        }
        return values[index++];
    }

    public boolean isSimple(int value) {
        boolean result = true;
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                result = false;
            }
        }
        return result;
    }
}
