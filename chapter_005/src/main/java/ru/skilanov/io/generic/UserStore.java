package ru.skilanov.io.generic;

/**
 * UserStore class.
 *
 * @param <T> AbstractStore
 */
public class UserStore<T extends User> extends AbstractStore<T> {

    /**
     * Constructor.
     *
     * @param size int
     */
    public UserStore(int size) {
        super(size);
    }
}
