package ru.skilanov.service;

/**
 * This class validate information.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * This method ask question and validate information.
     *
     * @param question String
     * @param range    int[]
     * @return value
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException mfe) {
                System.out.println("Please, input correct information: ");
            } catch (MenuOutException moe) {
                System.out.println("Please, select key from menu: ");
            }
        } while (invalid);
        return value;
    }
}

