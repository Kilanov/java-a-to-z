package ru.skilanov.service;

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
     *
     * @param input   Input
     * @param tracker Tracker
     */
    void execute(Input input, Tracker tracker);


    /**
     * This method show to user some information.
     *
     * @return String
     */
    String info();
}