package ru.skilanov.service;

import java.util.Scanner;


/**
 * This class input params from console.
 */
public class ConsoleInput implements Input {
    /**
     * @param scanner Scanner
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * This method asks for question and read input from console.
     *
     * @param question String
     * @return scanner Scanner
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}