package ru.skilanov.io.generic;

import java.util.NoSuchElementException;

/**
 * Abstract class for user and role.
 *
 * @param <T> Store
 */
public class AbstractStore<T extends Base> implements Store<T> {

    /**
     * SimpleArray
     */
    private SimpleArray<T> simpleArray;

    /**
     * Constructor.
     *
     * @param size int
     */
    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    /**
     * Add method.
     *
     * @param model T
     */
    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }

    /**
     * Replace method.
     *
     * @param id    String
     * @param model T
     * @return boolean
     */
    @Override
    public boolean replace(String id, T model) {
        int index = this.findIndex(id);
        if (index != -1) {
            this.simpleArray.update(index, model);
        } else {
            throw new NoSuchElementException();
        }
        return true;
    }

    /**
     * Delete method.
     *
     * @param id String
     * @return boolean
     */
    @Override
    public boolean delete(String id) {
        int index = this.findIndex(id);
        if (index != -1) {
            this.simpleArray.delete(index);
        } else {
            throw new NoSuchElementException();
        }
        return true;
    }

    /**
     * Find by id method.
     *
     * @param id String
     * @return T
     */
    @Override
    public T findById(String id) {
        int index = findIndex(id);
        return this.simpleArray.get(index);
    }

    /**
     * Find index method.
     *
     * @param id String
     * @return int
     */
    public int findIndex(String id) {
        int result = -1;
        for (int index = 0; index < simpleArray.objects.length; index++) {
            if (simpleArray.get(index) != null && simpleArray.get(index).getId().equals(id)) {
                result = index;
            }
        }
        return result;
    }
}
