package ru.skilanov.io.tree;

import java.util.Optional;

/**
 * Interface.
 *
 * @param <E> SimpleTree
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return
     */
    boolean add(E parent, E child);

    /**
     * findBy method.
     *
     * @param value E
     * @return Optional
     */
    Optional<Node<E>> findBy(E value);
}