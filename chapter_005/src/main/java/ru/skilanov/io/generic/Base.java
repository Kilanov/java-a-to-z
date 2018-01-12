package ru.skilanov.io.generic;

/**
 * Abstract class.
 */
public abstract class Base {
    /**
     * id var.
     */
    private final String id;

    /**
     * Constructor.
     * @param id String
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Getter.
     * @return String
     */
    public String getId() {
        return id;
    }
}