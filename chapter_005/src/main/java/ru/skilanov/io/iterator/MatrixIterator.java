package ru.skilanov.io.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is matrix array iterator class.
 */
public class MatrixIterator implements Iterator {

    /**
     * This is array
     */
    private final int[][] value;

    /**
     * This is raw of an array
     */
    private int raw;

    /**
     * This is column of an array
     */
    private int column;

    /**
     * This is constructor.
     *
     * @param value int[][]
     */
    MatrixIterator(final int[][] value) {
        this.value = value;
    }

    /**
     * This is hasNext method for an array.
     *
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        boolean result = raw < value.length - 1 || column < value[value.length - 1].length;
        return result;
    }

    /**
     * This is next method for an array.
     *
     * @return Object
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column >= value[raw].length) {
            raw++;
            column = 0;
        }
        return value[raw][column++];
    }
}
