package ru.skilanov.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class converts array to list and list to array.
 */
public class ConvertList {

    /**
     * This method converts array to list.
     *
     * @param array int[][]
     * @return List
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }

        return list;
    }

    /**
     * This method converts list to array.
     *
     * @param list List
     * @param rows int
     * @return array[][]
     */
    public int[][] toArray(List<Integer> list, int rows) {
        Iterator<Integer> iterator = list.iterator();
        int columns = list.size() / rows + (list.size() % rows == 0 ? 0 : 1);

        int[][] array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }

    /**
     * This method converts List<int[]> to List <Integer>.
     *
     * @param list int[]
     * @return Integer
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> convertedList = new ArrayList<>();

        for (int[] aList : list) {
            for (int num : aList) {
                convertedList.add(num);
            }
        }
        return convertedList;
    }
}

