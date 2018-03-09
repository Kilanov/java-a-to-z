package ru.skilanov.io.tree;

import java.util.*;

/**
 * Tree class.
 *
 * @param <E> E
 */
public class SimpleTreeImpl<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Node.
     */
    private Node<E> root;

    /**
     * Constructor.
     *
     * @param root E
     */
    SimpleTreeImpl(E root) {
        this.root = new Node<>(root);
    }

    /**
     * Add method.
     *
     * @param parent parent.
     * @param child  child.
     * @return boolean
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> node = findBy(parent);

        if (node != null) {
            if (node.get().leaves().contains(new Node<>(child))) {
                result = false;
            } else {
                Node<E> chNode = new Node<>(child);
                root.add(chNode);
                result = true;
            }
        }
        return result;
    }

    /**
     * Find method.
     *
     * @param value E
     * @return Optional<Node                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               <                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               E>>
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Iterator meyhod.
     *
     * @return Iterator
     */
    @Override
    public Iterator iterator() {
        return new SimpleTreeIterator();
    }

    /**
     * Iterator class.
     */
    private class SimpleTreeIterator implements Iterator<Node<E>> {
        /**
         * Queue.
         */
        private Queue<Node<E>> data = new LinkedList<>();

        /**
         * Constructor.
         */
        SimpleTreeIterator() {
            data.offer(root);
        }

        /**
         * hasNext method.
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return !data.isEmpty();
        }

        /**
         * Next method.
         *
         * @return Node
         */
        @Override
        public Node<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<E> el = data.poll();
            if (el != null) {
                for (Node<E> child : el.leaves()) {
                    data.offer(child);
                }
            }
            return el;
        }
    }
}
