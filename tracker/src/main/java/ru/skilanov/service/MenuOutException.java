package ru.skilanov.service;

/**
 * This class create menu out exception.
 */
public class MenuOutException extends RuntimeException {

    /**
     * Default constructor.
     *
     * @param msg String
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}