package ru.skilanov.models;

public class Comment {
    private String[] commentDescription;
    private int position = 0;

    public String[] getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String[] commentDescription) {
        this.commentDescription = commentDescription;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void add(String comment) {
        if (commentDescription == null) {
            commentDescription = new String[10];
        }
        this.commentDescription[position++] = comment;
    }
}