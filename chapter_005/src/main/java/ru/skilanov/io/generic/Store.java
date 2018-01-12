package ru.skilanov.io.generic;

/**
 * Interface Store.
 *
 * @param <T> Base
 */
public interface Store<T extends Base> {

    /**
     * Add method.
     *
     * @param model T
     */
    void add(T model);

    /**
     * Replace method.
     *
     * @param id    String
     * @param model T
     * @return boolean
     */
    boolean replace(String id, T model);

    /**
     * Delete method.
     *
     * @param id String
     * @return boolean
     */
    boolean delete(String id);

    /**
     * Find by id method.
     *
     * @param id String
     * @return T
     */
    T findById(String id);
}