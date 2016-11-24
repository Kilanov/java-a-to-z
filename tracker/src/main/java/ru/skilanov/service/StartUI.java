package ru.skilanov.service;

import ru.skilanov.models.Item;
import java.util.Scanner;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menuTracker = new MenuTracker(this.input, tracker);
        menuTracker.fillActions();
        do {
            menuTracker.show();
            int key = Integer.valueOf(input.ask("Please select"));
            menuTracker.select(key);
        } while (!"y".equals(this.input.ask("Please enter 'y' for exit")));
    }
}