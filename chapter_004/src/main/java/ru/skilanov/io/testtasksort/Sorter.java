package ru.skilanov.io.testtasksort;

import java.util.Arrays;
import java.util.Collections;

/**
 * This class sorts arrays.
 */
public class Sorter {

    /**
     * This method sorts array straight.
     *
     * @param list String[]
     * @return String[]
     */
    public String[] straightSort(String[] list) {
        Arrays.sort(list);
        return list;
    }

    /**
     * This method sorts array reverse.
     *
     * @param list String[]
     * @return String[]
     */
    public String[] reverseSort(String[] list) {
        Arrays.sort(list, Collections.reverseOrder());
        return list;
    }
}
