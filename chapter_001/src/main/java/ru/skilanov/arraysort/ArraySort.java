package ru.skilanov.arraysort;

/**
 * This class sort array by bubbleSort method.
 */
public class ArraySort {
    public int[] sort(int values[]) {
        for (int index = values.length - 1; index >= 0; index--) {
            for (int j = 0; j < index; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
        return values;
    }
}