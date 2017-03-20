package ru.skilanov.testtask.model;

import ru.skilanov.testtask.exceptions.ImpossibleMoveException;
import ru.skilanov.testtask.exceptions.FigureNotFoundException;
import ru.skilanov.testtask.exceptions.OccupiedWayException;

/**
 * This class describes chess board.
 */
public class Board {
    /**
     * This is constant param.
     */
    public static final int MAX_VALUE = 7;

    /**
     * This is constant param.
     */
    public static final int MIN_VALUE = 0;

    /**
     * This is constant param.
     */
    public static final int X_VALUE = 8;

    /**
     * This is constant param.
     */
    public static final int Y_VALUE = 8;

    /**
     * This is chess board array.
     */
    private Figure[][] figures = new Figure[X_VALUE][Y_VALUE];

    /**
     * This method adds figure on the board.
     *
     * @param figure Figure
     */
    public void addFigure(Figure figure) {
        this.figures[figure.getPosition().getX()][figure.getPosition().getY()] = figure;
    }

    /**
     * This method gets figure from the board.
     *
     * @param cell Cell
     * @return figures Figure
     */
    public Figure getFigure(Cell cell) {
        return figures[cell.getX()][cell.getY()];
    }

    /**
     * This method check possibility of the figure move.
     *
     * @param dist   Cell
     * @param source Cell
     * @return result boolean
     * @throws ImpossibleMoveException this way is impossible.
     * @throws OccupiedWayException this way was occupied.
     * @throws FigureNotFoundException figure doesn't exist.
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        boolean result = false;

        if (source.getX() == MIN_VALUE || source.getY() == MIN_VALUE) {
            throw new FigureNotFoundException("Figure not find");
        }

        if (dist.getX() < MIN_VALUE || dist.getX() > MAX_VALUE || dist.getY() < MIN_VALUE || dist.getY() > MAX_VALUE) {
            throw new ImpossibleMoveException("This move is impossible");
        }

        Cell[] way = figures[source.getX()][source.getY()].way(dist);

        for (Cell cell : way) {
            int x = cell.getX();
            int y = cell.getY();
            if (figures[x][y] != null) {
                throw new OccupiedWayException("This way is impossible");
            }
        }

        figures[dist.getX()][dist.getY()] = figures[source.getX()][source.getY()].clone(dist);

        result = true;

        return result;
    }
}


