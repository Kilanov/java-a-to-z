package ru.skilanov.io.map;

/**
 * Conteiner interface for the HashMap.
 *
 * @param <K> Object
 * @param <V> Object
 */
public interface HashMapContainer<K, V> extends Iterable {
    /**
     * Insert method.
     *
     * @param key   Object
     * @param value Object
     * @return boolean
     */
    boolean insert(K key, V value);

    /**
     * Get method.
     *
     * @param key Object
     * @return Object
     */
    V get(K key);

    /**
     * Delete method.
     *
     * @param key Object
     * @return boolean
     */
    boolean delete(K key);
}
