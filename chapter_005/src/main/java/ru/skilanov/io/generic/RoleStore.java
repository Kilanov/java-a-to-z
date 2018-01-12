package ru.skilanov.io.generic;

/**
 * RoleStore class.
 *
 * @param <T> AbstractStore
 */
public class RoleStore<T extends Role> extends AbstractStore<T> {
    /**
     * Constructor.
     *
     * @param size int
     */
    public RoleStore(int size) {
        super(size);
    }
}
