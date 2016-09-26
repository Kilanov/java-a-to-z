package ru.skilanov.factorial;

/**
 * This class calculate factorial.
 */
public class Factorial {
    /**
     * @param factorial int.
     */
    private int factorial;

    public Factorial(int factorial) {
        this.factorial = factorial;
    }

    /**
     * Calculate factorial.
     */
    public int calculate() {
        int result = 1;
        for (int index = 1; index <= factorial; index++) {
            result = result * index;
        }
        return result;
    }

    /**
     * Checked is it possible to calculate factorial.
     */
    public boolean exist() throws Exception {
        if (factorial > 0) {
            return true;
        } else {
            throw new Exception("This factorial doesn't exist");
        }
    }
}