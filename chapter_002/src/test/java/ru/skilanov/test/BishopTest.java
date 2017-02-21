package ru.skilanov.test;

import ru.skilanov.model.Bishop;
import ru.skilanov.model.Cell;
import ru.skilanov.exceptions.ImpossibleMoveException;
import ru.skilanov.model.Figure;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * This is bishop Class tests.
 */
public class BishopTest {

    /**
     * This is constant param.
     */
    public static final int NULL_VALUE = 0;

    /**
     * This is constant param.
     */
    public static final int TWO_VALUE = 2;

    /**
     * This is constant param.
     */
    public static final int ONE_VALUE = 1;

    /**
     * This is impossible move exception test.
     * @throws ImpossibleMoveException figure can't move this way.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenInputWrongWayThemReturnException() throws ImpossibleMoveException {
        Bishop bishop = new Bishop(new Cell(NULL_VALUE, TWO_VALUE));

        Cell dist = new Cell(TWO_VALUE, TWO_VALUE);

        bishop.way(dist);
    }

    /**
     * This is clone test.
     */
    @Test
    public void whenCallCloneThenReturnNewPosition() {
        Bishop bishop = new Bishop(new Cell(NULL_VALUE, TWO_VALUE));

        Cell dist = new Cell(TWO_VALUE, NULL_VALUE);

        Figure[] figures = new Figure[ONE_VALUE];
        figures[NULL_VALUE] = bishop.clone(dist);

        assertNotNull(figures[0]);
    }
}