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

    /**
     * This method asks for question and read input from console in the range.
     *
     * @param question String
     * @param range    int[]
     * @return key
     */
    public int ask(String question, int[] range) {
        int key = Integer.parseInt(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
