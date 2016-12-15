package ru.skilanov.service;

/**
 * This is abstract class that realize info method for MenuTracker.
 */
public abstract class BaseAction implements UserAction {
    /**
     * name param.
     */
    private String name;

    /**
     * Default constructor.
     * @param name String
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     * This method realize info method.
     * @return String
     */
    public String info() {
        return String.format("%s %s", this.key(), this.name);
    }
}