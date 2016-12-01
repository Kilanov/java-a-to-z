package ru.skilanov.service;

/**
 * This class starts our application.
 */
public class StartUI {
    /**
     * Input param.
     */
    private Input input;
    /**
     * Tracker param.
     */
    private Tracker tracker;

    /**
     * Default constructor.
     *
     * @param input Input
     * @param tracker Tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * main method of the our application.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        new StartUI(input, tracker).init();
    }

    /**
     * This method starts our menu.
     */
    public void init() {
        MenuTracker menuTracker = new MenuTracker(this.input, tracker);
        menuTracker.fillActions();
        final int[] range = new int[]{0, 1, 2, 3, 4, 5, 6};
        do {
            menuTracker.show();
            menuTracker.select(input.ask("Select: ", range));
        } while (!"y".equals(this.input.ask("Please enter 'y' for exit")));
    }
}
