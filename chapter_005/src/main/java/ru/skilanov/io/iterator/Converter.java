package ru.skilanov.io.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is converter class for iterators.
 */
public class Converter {
    /**
     * This is convert method.
     * @param it Iterator
     * @return Iterator
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            /**
             * This is variable
             */
            Iterator<Integer> iterator;

            /**
             * This is hasNext method for iterator of iterators.
             * @return boolean
             */
            @Override
            public boolean hasNext() {
                boolean result = true;
                while (iterator == null || !iterator.hasNext()) {
                    if (!it.hasNext()) {
                        result = false;
                    }
                    iterator = it.next();
                }
                return result;
            }

            /**
             * This is next method for iterator.
             * @return Integer
             */
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}