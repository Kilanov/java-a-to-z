package ru.skilanov.model;

/**
 * This class is model of the cell.
 */
public class Cell {
    /**
     * This is int x coordinate param.
     */
    private int x;

    /**
     * This is int y coordinate param.
     */
    private int y;

    /**
     * This is default constructor.
     * @param x int
     * @param y int
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This is getter method.
     * @return x int
     */
    public int getX() {
        return x;
    }

    /**
     * This is setter method.
     * @param x int
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * This is getter method.
     * @return y int
     */
    public int getY() {
        return y;
    }

    /**
     * This is setter method.
     * @param y int
     */
    public void setY(int y) {
        this.y = y;
    }
}

