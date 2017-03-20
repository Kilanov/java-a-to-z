package ru.skilanov.testtask.model;

import ru.skilanov.testtask.exceptions.ImpossibleMoveException;

/**
 * This is class of chess model.
 */
public class Bishop extends Figure {

    /**
     * This is constant param.
     */
    public static final int MAX_VALUE = 7;

    /**
     * This is constant param.
     */
    public static final int MIN_VALUE = 0;

    /**
     * This is constructor.
     *
     * @param position Cell
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * This method describes way of Bishop.
     *
     * @param dist Cell
     * @return result Boolean.
     * @throws ImpossibleMoveException figure can't move this way.
     */
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int x = dist.getX();
        int y = dist.getY();
        int x2 = this.getPosition().getX();
        int y2 = this.getPosition().getY();

        int xMove = Math.abs(x - x2);
        int yMove = Math.abs(y - y2);

        Cell[] result = new Cell[xMove];

        if (xMove == yMove && x >= MIN_VALUE && x <= MAX_VALUE && y >= MIN_VALUE && y <= MAX_VALUE) {

            for (int i = 0; i < xMove; i++) {
                result[i] = new Cell((x2 + (i + 1) * xMove / xMove), (y2 + (i + 1) * yMove / yMove));
            }
        } else {
            throw new ImpossibleMoveException("This move is impossible");
        }
        return result;
    }

    /**
     * This method clone Bishop.
     *
     * @param dist Cell
     * @return Bishop
     */
    public Figure clone(Cell dist) {
        return new Bishop(dist);
    }
}
