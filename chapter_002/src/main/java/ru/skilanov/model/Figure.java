package ru.skilanov.model;

import ru.skilanov.exceptions.ImpossibleMoveException;

/**
 * This is abstract class of the figures model.
 */
public abstract class Figure {
    /**
     * This is constant param.
     */
    private final Cell position;

    /**
     * This is constructor.
     *
     * @param position Cell
     */
    Figure(Cell position) {
        this.position = position;
    }

    /**
     * This is abstract method of the figure way.
     *
     * @param dist Cell
     * @throws ImpossibleMoveException this move is impossible.
     * @return Cell
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * This is abstract method of the figure clone.
     * @param dist Cell
     * @return Figure
     */
    public abstract Figure clone(Cell dist);

    /**
     * This is getter.
     *
     * @return position Cell
     */
    public Cell getPosition() {
        return position;
    }
}