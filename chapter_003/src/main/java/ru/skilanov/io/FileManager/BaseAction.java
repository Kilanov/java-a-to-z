package ru.skilanov.io.fileManager;

/**
 * This is abstract class that realized info method for Client and Server.
 */
public abstract class BaseAction implements UserAction {
    /**
     * name param.
     */
    private String name;

    /**
     * Default constructor.
     *
     * @param name String
     */
    public BaseAction(final String name) {
        this.name = name;
    }

    /**
     * This method realize info method.
     *
     * @return String
     */
    public final String info() {
        return String.format("%s %s", this.key(), this.name);
    }
}
