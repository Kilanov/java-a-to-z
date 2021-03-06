package ru.skilanov.io.set;

import ru.skilanov.io.list.SimpleArrayList;

/**
 * Array set class.
 *
 * @param <E> E
 */
public class SimpleArraySet<E> extends SimpleArrayList<E> {
    /**
     * Add method.
     *
     * @param value E
     */
    @Override
    public void add(E value) {
        if (isExist(value)) {
            super.add(value);
        }
    }

    /**
     * Get size method.
     *
     * @return int
     */
    @Override
    public int getSize() {
        return super.getSize();
    }

    /**
     * Is exist method.
     *
     * @param e E
     * @return boolean
     */
    private boolean isExist(E e) {
        boolean result = true;
        for (int i = 0; i < size; i++) {
            if (container[i].equals(e)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
