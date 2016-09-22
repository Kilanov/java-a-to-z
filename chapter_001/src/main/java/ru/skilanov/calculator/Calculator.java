package ru.skilanov.calculator;

/**
 * Ñalculator, calculate arithmetic operations.
 */

public class Ñalculator {

    /**
     * Result of calculations.
     */
    private double result;

    /**
     * Add and save result.
     * @param first  double.
     * @param second double.
     */

    public void add(double first, double second) {
        result = first + second;
    }

    /**
     * Subtract and save result.
     * @param first  double.
     * @param second double.
     */

    public void substruct(double first, double second) {
        result = first - second;
    }

    /**
     * Div and save result.
     * @param first  double.
     * @param second double.
     */

    public void div(double first, double second) {
        result = first / second;
    }

    /**
     * Multiple and save result.
     * @param first  double.
     * @param second double.
     */

    public void multiple(double first, double second) {
        result = first * second;
    }

    /**
     * return result.
     */

    public double getResult() {
        return result;
    }
}
