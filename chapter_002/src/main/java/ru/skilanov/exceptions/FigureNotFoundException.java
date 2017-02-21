package ru.skilanov.exceptions;

/**
 * Figure not found exception.
 */
public class FigureNotFoundException extends RuntimeException {

    /**
     * This is figure not found exception method.
     *
     * @param msg String
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}