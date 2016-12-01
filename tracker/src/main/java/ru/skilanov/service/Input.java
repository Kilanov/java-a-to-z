package ru.skilanov.service;

/**
 * This interface created for ask question.
 */
public interface Input {
    /**
     * This method asks questions.
     * @param question String
     * @return question String
     */
    String ask(String question);

    /**
     * This method asks questions in range.
     * @param question String
     * @param range int[]
     * @return String, int[]
     */
    int ask(String question, int[] range);
}