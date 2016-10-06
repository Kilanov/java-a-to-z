package ru.skilanov.arraysturning;

/**
 * This class turns array.
 */
public class ArraysTurning {

    /**
     * Array turns algorithm.
     */
    public int[][] turnArray(int[][] values) {
        for (int i = 0; i < values.length / 2; i++) {
            for (int j = i; j < values.length - 1 - i; j++) {
                int tmp = values[i][j];
                values[i][j] = values[values.length - j - 1][i];
                values[values.length - j - 1][i] = values[values.length - i - 1][values.length - j - 1];
                values[values.length - i - 1][values.length - j - 1] = values[j][values.length - i - 1];
                values[j][values.length - i - 1] = tmp;
            }
        }
        return values;
    }
}