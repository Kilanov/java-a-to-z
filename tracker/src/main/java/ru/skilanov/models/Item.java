package ru.skilanov.models;

/**
 * This class is a model for Item.
 */
public class Item {
    /**
     * @param name String
     */
    private String name;
    /**
     * @param description String
     */
    private String description;
    /**
     * @param id String
     */
    private String id;
    /**
     * @param date int
     */
    private int date;
    /**
     * @param comment Comment
     */
    private Comment comment = new Comment();

    /**
     * Default constructor.
     */
    public Item() {
    }


    /**
     * @param name        String
     * @param description String
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * @param name        String
     * @param description String
     * @param id          String
     * @param date        int
     */
    public Item(String name, String description, String id, int date) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.date = date;
    }

    /**
     * Getter for name.
     *
     * @return name
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
     * @return description
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

    /**
     * Getter for id.
     *
     * @return ud
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for id.
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for date.
     *
     * @return date
     */
    public int getDate() {
        return date;
    }

    /**
     * Setter for date.
     *
     * @param date int
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * Getter for comment.
     *
     * @return comment
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Setter for comment.
     *
     * @param comment Comment
     */
    public void setComment(Comment comment) {
        this.comment = comment;
    }
}