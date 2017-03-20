package ru.skilanov.test;

import ru.skilanov.testtask.model.Bishop;
import ru.skilanov.testtask.model.Board;
import ru.skilanov.testtask.model.Cell;
import ru.skilanov.testtask.exceptions.FigureNotFoundException;
import ru.skilanov.testtask.exceptions.ImpossibleMoveException;
import ru.skilanov.testtask.exceptions.OccupiedWayException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * This is board class tests.
 */
public class BoardTest {
    /**
     * This is constant param.
     */
    public static final int OUT_OF_BOUNDS_VALUE = 8;

    /**
     * This is constant param.
     */
    public static final int SOURCE_VALUE = 1;

    /**
     * This is constant param.
     */
    public static final int DIST_VALUE = 2;

    /**
     * This is constant param.
     */
    public static final int NULL_OUT_OF_BOUNDS = 0;

    /**
     * This is Figure not found exception test.
     *
     * @throws FigureNotFoundException figure doesn't exist.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenSetNullSourceCellThenReturnFigureNotFoundException() {
        Board board = new Board();
        Cell source = new Cell(NULL_OUT_OF_BOUNDS, NULL_OUT_OF_BOUNDS);
        Cell dist = new Cell(DIST_VALUE, DIST_VALUE);

        board.move(source, dist);
    }

    /**
     * This is impossible move exception test.
     *
     * @throws ImpossibleMoveException figure can't move this way.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenSetOutOfBoundsValueTheReturnImpossibleMoveException() {
        Board board = new Board();
        Cell source = new Cell(SOURCE_VALUE, SOURCE_VALUE);
        Cell dist = new Cell(OUT_OF_BOUNDS_VALUE, OUT_OF_BOUNDS_VALUE);

        board.move(source, dist);
    }

    /**
     * This is add figure test.
     */
    @Test
    public void wenSetAddFigureThenReturnTrue() {
        Board board = new Board();

        Cell source = new Cell(SOURCE_VALUE, SOURCE_VALUE);
        Cell dist = new Cell(DIST_VALUE, DIST_VALUE);

        board.addFigure(new Bishop(source));
        Cell[] result = board.getFigure(source).way(dist);

        assertNotNull(result);
    }

    /**
     * This is move figure test.
     *
     * @throws FigureNotFoundException figure doesn't exist.
     * @throws ImpossibleMoveException figure can't move this way.
     * @throws OccupiedWayException    this way was occupied.
     */
    @Test
    public void whenMoveThenReturnTrue() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(SOURCE_VALUE, SOURCE_VALUE);
        Cell dist = new Cell(DIST_VALUE, DIST_VALUE);
        board.addFigure(new Bishop(source));

        Boolean result = board.move(source, dist);

        assertThat(result, is(true));
    }
}