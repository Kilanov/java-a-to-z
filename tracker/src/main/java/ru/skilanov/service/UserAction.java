package ru.skilanov.service;

public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}