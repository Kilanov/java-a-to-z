package ru.skilanov.service;

/**
 * This class gets inputs params not from console.
 */
public class StubInput implements Input {
    /**
     * answers param.
     */
    private String[] answers;
    /**
     * position param.
     */
    private int position = 0;

    /**
     * This is constructor.
     *
     * @param answers String[]
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * This method asks user and return answers.
     *
     * @param question String
     * @return answers
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * This method asks user and return answers in the range.
     *
     * @param question String
     * @param range    int[]
     * @return key
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
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
            throw new MenuOutException("Out of menu range.");
        }
    }
}