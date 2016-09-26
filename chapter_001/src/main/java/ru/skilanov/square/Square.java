package ru.skilanov.square;

/**
 * Square finds function ax^2+bx+c.
 */
public class Square {
    /**
     * @param a first number.
     * @param b second number.
     * @param c third number.
     */
    public int a;
    public int b;
    public int c;

    public Square(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Calculate function ax^2+bx+c with set parameters.
     */
    public float calculate(int x) {
        return (float) (a * Math.pow(x, 2) + b * x + c);
    }

    /**
     * Show result.
     */
    public void show(int start, int finish, int step) {
        for (int index = start; index <= finish; index += step) {
            System.out.println(calculate(index));
        }
    }
}

