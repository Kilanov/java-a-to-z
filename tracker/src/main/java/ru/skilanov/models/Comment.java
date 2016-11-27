package ru.skilanov.models;

/**
 * This class created cpmments.
 */
public class Comment {

    /**
     * @param this is static variable
     */
    public static final int INT = 10;
    /**
     * @param commentDescription String[]
     */
    private String[] commentDescription;
    /**
     * @param position int
     */
    private int position = 0;

    /**
     * Getter for commentDescription.
     *
     * @return commentDescription
     */
    public String[] getCommentDescription() {
        return commentDescription;
    }

    /**
     * Setter for commentDescription.
     *
     * @param commentDescription String[]
     */
    public void setCommentDescription(String[] commentDescription) {
        this.commentDescription = commentDescription;
    }

    /**
     * Getter for position.
     *
     * @return position.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Setter for position.
     *
     * @param position int
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * This method add comment.
     *
     * @param comment String
     */
    public void add(String comment) {
        if (commentDescription == null) {
            commentDescription = new String[INT];
        }
        this.commentDescription[position++] = comment;
    }
}