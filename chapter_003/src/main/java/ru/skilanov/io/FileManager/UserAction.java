package ru.skilanov.io.fileManager;

/**
 * This interface makes users actions.
 */
public interface UserAction {
    /**
     * This method gives position of the action in the menu.
     *
     * @return int
     */
    int key();

    /**
     * This method execute of the action.
     */
    void execute();

    /**
     * This method show to user some information.
     *
     * @return String
     */
    String info();
}