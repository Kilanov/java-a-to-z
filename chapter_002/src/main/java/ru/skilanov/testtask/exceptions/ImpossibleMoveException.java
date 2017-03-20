package ru.skilanov.testtask.exceptions;

/**
 * Impossible move exception.
 */
public class ImpossibleMoveException extends RuntimeException {

    /**
     * This is impossible move exception method.
     *
     * @param msg String
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
