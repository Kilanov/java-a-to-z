package ru.skilanov.models;

/**
 * This class is a model for task that extends Item.
 */
public class Task extends Item {

    /**
     * @param name String
     */
    private String name;
    /**
     * @param description String
     */
    private String description;

    /**
     * Constructor for Task.
     *
     * @param name        String
     * @param description String
     */
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Getter for name.
     *
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for description.
     *
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description.
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }
}