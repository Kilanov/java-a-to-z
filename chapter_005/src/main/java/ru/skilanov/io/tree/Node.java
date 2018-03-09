package ru.skilanov.io.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Node class.
 *
 * @param <E> Node
 */
public class Node<E extends Comparable<E>> {
    /**
     * List variable.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * E variable.
     */
    private final E value;

    /**
     * Constructor.
     *
     * @param value E
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Add method.
     *
     * @param child Node
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Leaves method.
     *
     * @return List
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * EqValue method.
     *
     * @param that E
     * @return boolean
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
}