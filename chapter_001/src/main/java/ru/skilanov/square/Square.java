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
    public void show() {
        Square square = new Square(2, 3, 4);
        int x1 = 1;
        int x2 = 2;

        for (int index = x1; index <= x2; index++) {
            System.out.println(square.calculate(index));
        }
    }
}
