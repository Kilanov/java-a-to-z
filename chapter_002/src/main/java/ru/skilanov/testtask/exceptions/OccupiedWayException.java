package ru.skilanov.testtask.exceptions;

/**
 * Occupied way exception.
 */
public class OccupiedWayException extends RuntimeException {

    /**
     * This is occupied way exception method.
     *
     * @param msg String
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
